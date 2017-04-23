package com.easycms.plug.weixin.manager;

import java.util.List;

import com.easycms.common.page.Pagination;
import com.easycms.plug.weixin.entity.WeixinMenu;

public interface WeixinMenuMng {
	
	public Pagination getPage(Integer siteId,Integer parentId
			,int pageNo,int pageSize);
	
	public List<WeixinMenu> getList(Integer siteId,Integer count);
	
	public WeixinMenu findById(Integer id);
	
	public WeixinMenu save(WeixinMenu bean);
	
	public WeixinMenu update(WeixinMenu bean);
	
	public WeixinMenu deleteById(Integer id);
	
	public WeixinMenu[] deleteByIds(Integer[] ids);
}
