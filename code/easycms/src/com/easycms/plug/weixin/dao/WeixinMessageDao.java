package com.easycms.plug.weixin.dao;

import java.util.List;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;
import com.easycms.plug.weixin.entity.WeixinMessage;

public interface WeixinMessageDao {
	
	public Pagination getPage(Integer siteId,int pageNo,int pageSize);
	
	public List<WeixinMessage> getList(Integer siteId);
	
	public WeixinMessage getWelcome(Integer siteId);
	
	public WeixinMessage findByNumber(String number,Integer siteId);
	
	public WeixinMessage save(WeixinMessage bean);
	
	public WeixinMessage findById(Integer id);
	
	public WeixinMessage deleteById(Integer id);

	public WeixinMessage updateByUpdater(Updater<WeixinMessage> updater);
}
