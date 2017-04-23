package com.easycms.cms.action.member;

import static com.easycms.cms.Constants.TPLDIR_CSI;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycms.common.web.RequestUtils;
import com.easycms.core.entity.CmsSite;
import com.easycms.core.web.util.CmsUtils;
import com.easycms.core.web.util.FrontUtils;

/**
 * 前台会员登录
 * @Author Administrator
 * @DATE 2017/4/20
 */
@Controller
public class LoginAct {
	public static final String LOGIN_CSI = "tpl.loginCsi";
	public static final String TPL_SPACE = "tpl.space";

	/**
	 * 跳转会员登录页面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login_csi.jspx")
	public String csi(HttpServletRequest request, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		// 将request中所有参数
		model.putAll(RequestUtils.getQueryParams(request));
		FrontUtils.frontData(request, model, site);
		return FrontUtils.getTplPath(request, site.getSolutionPath(), TPLDIR_CSI, LOGIN_CSI);
	}

}
