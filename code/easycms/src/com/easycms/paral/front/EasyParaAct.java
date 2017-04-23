package com.easycms.paral.front;

import com.easycms.cms.action.member.RegisterAct;
import com.easycms.cms.entity.assist.CmsWebservice;
import com.easycms.cms.manager.assist.CmsFileMng;
import com.easycms.cms.manager.assist.CmsWebserviceMng;
import com.easycms.common.email.EmailSender;
import com.easycms.common.email.MessageTemplate;
import com.easycms.common.upload.FileRepository;
import com.easycms.common.web.RequestUtils;
import com.easycms.common.web.session.SessionProvider;
import com.easycms.common.web.springmvc.MessageResolver;
import com.easycms.core.entity.*;
import com.easycms.core.manager.*;
import com.easycms.core.web.WebErrors;
import com.easycms.core.web.util.CmsUtils;
import com.easycms.core.web.util.FrontUtils;
import com.easycms.paral.entity.ParaTask;
import com.easycms.paral.service.EasyParaService;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.easycms.cms.Constants.TPLDIR_INDEX;
import static com.easycms.cms.Constants.TPLDIR_MEMBER;
import static org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;

/**
 * 暂时访问控制类
 * @Author Administrator
 * @DATE 2017/4/19
 */
@Controller
public class EasyParaAct {
    private static final Logger log = LoggerFactory.getLogger(RegisterAct.class);

    public static final String REGISTER = "tpl.register";
    public static final String REGISTER_RESULT = "tpl.registerResult";
    public static final String REGISTER_ACTIVE_SUCCESS = "tpl.registerActiveSuccess";
    public static final String LOGIN_INPUT = "tpl.loginInput";

    @Autowired
    private CmsWebserviceMng cmsWebserviceMng;
    @Autowired
    private UnifiedUserMng unifiedUserMng;
    @Autowired
    private CmsUserMng cmsUserMng;
    @Autowired
    private SessionProvider session;
    @Autowired
    private ImageCaptchaService imageCaptchaService;
    @Autowired
    private ConfigMng configMng;
    @Autowired
    private CmsConfigItemMng cmsConfigItemMng;
    @Autowired
    private DbFileMng dbFileMng;
    @Autowired
    private CmsFileMng fileMng;
    @Autowired
    protected FileRepository fileRepository;
    @Autowired
    protected EasyParaService easyParaService;

    @RequestMapping(value = "/login.jhtml", method = RequestMethod.GET)
    public String login(String returnUrl, HttpServletRequest request, HttpServletResponse response,ModelMap model) {
        CmsSite site = CmsUtils.getSite(request);
        String sol = site.getSolutionPath();
        Integer errorTimes=configMng.getConfigLogin().getErrorTimes();
        model.addAttribute("errorTimes", errorTimes);
        model.addAttribute("site",site);
        if(StringUtils.isBlank(returnUrl)){
            session.setAttribute(request, response, "loginSource", null);
        }
        Object source=session.getAttribute(request, "loginSource");
        if(source!=null){
            String loginSource=(String) source;
            model.addAttribute("loginSource",loginSource);
        }
        FrontUtils.frontData(request, model, site);
        return "/WEB-INF/t/cms/www/default/index/login.html";
    }

    @RequestMapping(value = "/login.jspx", method = RequestMethod.POST)
    public String login2(String username, HttpServletRequest request, HttpServletResponse response,ModelMap model) {
        CmsSite site = CmsUtils.getSite(request);
        String sol = site.getSolutionPath();
        Object error = request.getAttribute(DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);

        if (error != null) {
            model.addAttribute("error",error);
            model.addAttribute("errorRemaining", unifiedUserMng.errorRemaining(username));
            return "redirect:login.jhtml";
        }
        session.setAttribute(request, response, "loginSource", null);
        FrontUtils.frontData(request, model, site);
//        response.sendRedirect("index.jhtml");
        return "redirect:index.jhtml";
    }

    @RequestMapping(value = "/register.jhtml", method = RequestMethod.GET)
    public String register(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        data(request, response, model);
        return "/WEB-INF/t/cms/www/default/index/register.html";
    }

    @RequestMapping(value = "/register2.jspx", method = RequestMethod.POST)
    public String register2(String username, String email, String loginPassword,
                         CmsUserExt userExt, String captcha, String nextUrl,
                         HttpServletRequest request, HttpServletResponse response,
                         ModelMap model) throws IOException {
        CmsSite site = CmsUtils.getSite(request);
        CmsConfig config = site.getConfig();
        WebErrors errors = validateSubmit(username, email, loginPassword, captcha, site, request, response);
        boolean disabled = false;
        if(config.getMemberConfig().isCheckOn()){
            disabled = true;
        }
        if (errors.hasErrors()) {
            return FrontUtils.showError(request, response, model, errors);
        }
        String ip = RequestUtils.getIpAddr(request);
        Map<String,String> attrs=RequestUtils.getRequestMap(request, "attr_");
        if (config.getEmailValidate()) {
            EmailSender sender = configMng.getEmailSender();
            MessageTemplate msgTpl = configMng.getRegisterMessageTemplate();
            if (sender == null) {
                // 邮件服务器没有设置好
                model.addAttribute("status", 4);
            } else if (msgTpl == null) {
                // 邮件模板没有设置好
                model.addAttribute("status", 5);
            } else {
                try {
                    cmsUserMng.registerMember(username, email, loginPassword, ip, null,disabled,userExt,attrs, false, sender, msgTpl);
                    cmsWebserviceMng.callWebService("false",username, loginPassword, email, userExt, CmsWebservice.SERVICE_TYPE_ADD_USER);
                    model.addAttribute("status", 0);
                } catch (UnsupportedEncodingException e) {
                    // 发送邮件异常
                    model.addAttribute("status", 100);
                    model.addAttribute("message", e.getMessage());
                    log.error("send email exception.", e);
                } catch (MessagingException e) {
                    // 发送邮件异常
                    model.addAttribute("status", 101);
                    model.addAttribute("message", e.getMessage());
                    log.error("send email exception.", e);
                }
            }
            log.info("member register success. username={}", username);
            FrontUtils.frontData(request, model, site);
            if (!StringUtils.isBlank(nextUrl)) {
                response.sendRedirect(nextUrl);
                return null;
            } else {
                return FrontUtils.getTplPath(request, site.getSolutionPath(), TPLDIR_MEMBER, REGISTER_RESULT);
            }
        } else {
            cmsUserMng.registerMember(username, email, loginPassword, ip, null,null, true,userExt,attrs);
            cmsWebserviceMng.callWebService("false",username, loginPassword, email, userExt,CmsWebservice.SERVICE_TYPE_ADD_USER);
            log.info("member register success. username={}", username);
            FrontUtils.frontData(request, model, site);
            FrontUtils.frontPageData(request, model);
            model.addAttribute("success", true);
            return "/WEB-INF/t/cms/www/default/index/login.html";
        }
//        return "/WEB-INF/t/cms/www/default/index/register.html";
    }

    @RequestMapping(value = "/product.jhtml", method = RequestMethod.GET)
    public String product(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        data(request, response, model);
        return "/WEB-INF/t/cms/www/default/index/product.html";
    }

    @RequestMapping(value = "/business.jhtml", method = RequestMethod.GET)
    public String business(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        data(request, response, model);
        CmsUser user= CmsUtils.getUser(request);
        List<ParaTask> paraTasks = easyParaService.getLists(user);
        model.addAttribute("paraTasks", paraTasks);
        return "/WEB-INF/t/cms/www/default/index/business.html";
    }

    @RequestMapping(value = "/platform.jhtml", method = RequestMethod.GET)
    public String platform(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        data(request, response, model);
        List<CmsUser> users = cmsUserMng.getList("", "", null, null, null, false, null);
        model.addAttribute("users", users);

        CmsUser user= CmsUtils.getUser(request);
        List<ParaTask> paraTasks = easyParaService.getLists(user);
        model.addAttribute("paraTasks", paraTasks);
        return "/WEB-INF/t/cms/www/default/index/platform.html";
    }

    @RequestMapping(value = "/muser.jspx", method = RequestMethod.POST)
    public String muser(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        data(request, response, model);
        String userid = (String) request.getParameter("userid");
        String dele = (String) request.getParameter("dele");
        if(dele!=null && dele.equals("edit")){
            CmsUser user = cmsUserMng.findById(Integer.valueOf(userid));
            user.setDisabled(false);
            cmsUserMng.updateUser(user);
        } else {
            cmsUserMng.deleteById(Integer.valueOf(userid));
        }
        return "redirect:platform.jhtml";
    }

    @RequestMapping(value = "/ptask.jspx", method = RequestMethod.POST)
    public String ptask(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        data(request, response, model);
        String tid = (String) request.getParameter("tid");
        String dele = (String) request.getParameter("dele");
        if(dele!=null && dele.equals("edit")){
            ParaTask task = easyParaService.findById(Integer.valueOf(tid));
            task.setStatus("进行中");
            task.setEdate(new Date());
            easyParaService.updateTask(task);
        } else {
            easyParaService.deleteById(Integer.valueOf(tid));
        }

        return "redirect:platform.jhtml";
    }

    @RequestMapping(value = "/about.jhtml", method = RequestMethod.GET)
    public String about(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        data(request, response, model);
        return "/WEB-INF/t/cms/www/default/index/about.html";
    }

    @RequestMapping(value = "/contact.jhtml", method = RequestMethod.GET)
    public String contact(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        data(request, response, model);
        return "/WEB-INF/t/cms/www/default/index/contact.html";
    }

    public String data(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
        CmsSite site = CmsUtils.getSite(request);
        //设置model参数
        FrontUtils.frontData(request, model, site);
        return "";
    }

    private WebErrors validateSubmit(String username, String email,
                                     String password, String captcha, CmsSite site,
                                     HttpServletRequest request, HttpServletResponse response) {
        MemberConfig mcfg = site.getConfig().getMemberConfig();
        WebErrors errors = WebErrors.create(request);

        if (errors.ifOutOfLength(username, MessageResolver.getMessage(request, "field.username"), mcfg.getUsernameMinLen(), 100)) {
            return errors;
        }
        if (errors.ifNotUsername(username,MessageResolver.getMessage(request, "field.username"), mcfg.getUsernameMinLen(), 100)) {
            return errors;
        }
        if (errors.ifOutOfLength(password, MessageResolver.getMessage(request, "field.password"), mcfg.getPasswordMinLen(), 100)) {
            return errors;
        }
        if (errors.ifNotEmail(email, MessageResolver.getMessage(request, "field.email"), 100)) {
            return errors;
        }
        // 保留字检查不通过，返回false。
        if (!mcfg.checkUsernameReserved(username)) {
            errors.addErrorCode("error.usernameReserved");
            return errors;
        }
        // 用户名存在，返回false。
        if (unifiedUserMng.usernameExist(username)) {
            errors.addErrorCode("error.usernameExist");
            return errors;
        }
        return errors;
    }

    @RequestMapping("/member/upload_para_task.jspx")
    public String uploadAttachment(@RequestParam(value = "taskfile", required = false) MultipartFile file,
            HttpServletRequest request, ModelMap model) {
        CmsSite site = CmsUtils.getSite(request);
        CmsUser user= CmsUtils.getUser(request);
        String origName = file.getOriginalFilename();
        String ext = FilenameUtils.getExtension(origName).toLowerCase(Locale.ENGLISH);
//        WebErrors errors = validateUpload(file,request);
//        if (errors.hasErrors()) {
//            model.addAttribute("error", errors.getErrors().get(0));
//            return FrontUtils.getTplPath(request, site.getSolutionPath(), TPLDIR_MEMBER, CONTRIBUTE_UPLOADATTACHMENT);
//        }
        try {
            String fileUrl;
            ParaTask ptask = null;
            if (site.getUploadFtp() != null) {
                Ftp ftp = site.getUploadFtp();
                String ftpUrl = ftp.getUrl();
                fileUrl = ftp.storeByExt(site.getUploadPath(), ext, file.getInputStream());
                // 加上url前缀
                fileUrl = ftpUrl + fileUrl;
                ptask = new ParaTask(origName, new Date(),"待审核","",user.getId(),fileUrl,"",origName, fileUrl, user.getUsername());
            } else {
                String ctx = request.getContextPath();
                fileUrl = fileRepository.storeByExt(site.getUploadPath(), ext, file);
                // 加上部署路径
                fileUrl = ctx + fileUrl;
                ptask = new ParaTask(origName, new Date(),"待审核","",user.getId(),fileUrl,"",origName, fileUrl.substring(fileUrl.lastIndexOf("/") +1, fileUrl.length()), user.getUsername());
            }
            easyParaService.save(ptask);
            cmsUserMng.updateUploadSize(user.getId(), Integer.parseInt(String.valueOf(file.getSize()/1024)));
            fileMng.saveFileByPath(fileUrl, origName, false);
            model.addAttribute("attachmentPath", fileUrl);
            model.addAttribute("attachmentName", origName);
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
        } catch (IOException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:business.jhtml";
    }

}
