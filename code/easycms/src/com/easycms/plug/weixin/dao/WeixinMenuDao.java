package com.easycms.plug.weixin.dao;

import java.util.List;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;
import com.easycms.plug.weixin.entity.WeixinMenu;

public interface WeixinMenuDao {
	
	public Pagination getPage(Integer siteId,Integer parentId,int pageNo,int pageSize);
	
	public List<WeixinMenu> getList(Integer siteId,Integer count);
	
	public WeixinMenu findById(Integer id);
	
	public WeixinMenu save(WeixinMenu bean);

	public WeixinMenu updateByUpdater(Updater<WeixinMenu> updater);
	
	public WeixinMenu deleteById(Integer id);
}
