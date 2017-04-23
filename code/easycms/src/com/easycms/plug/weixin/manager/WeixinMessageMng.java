package com.easycms.plug.weixin.manager;

import java.util.List;

import com.easycms.common.page.Pagination;
import com.easycms.plug.weixin.entity.WeixinMessage;

public interface WeixinMessageMng {
	
	public Pagination getPage(Integer siteId,int pageNo,int pageSize);
	
	public List<WeixinMessage> getList(Integer siteId);
	
	public WeixinMessage getWelcome(Integer siteId);
	
	public WeixinMessage findByNumber(String number,Integer siteId);
	
	public WeixinMessage findById(Integer id);
	
	public WeixinMessage save(WeixinMessage bean);
	
	public WeixinMessage update(WeixinMessage bean);
	
	public WeixinMessage deleteById(Integer id);
	
	public WeixinMessage[] deleteByIds(Integer[] ids);
	
}
