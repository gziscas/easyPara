package com.easycms.plug.weixin.dao;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;
import com.easycms.plug.weixin.entity.Weixin;

public interface WeixinDao {
	
	public Pagination getPage(Integer siteId,int pageNo,int pageSize);
	
	public Weixin save(Weixin bean);
	
	public Weixin deleteById(Integer id);
	
	public Weixin findById(Integer id);
	
	public Weixin find(Integer siteId);

	public Weixin updateByUpdater(Updater<Weixin> updater);
}
