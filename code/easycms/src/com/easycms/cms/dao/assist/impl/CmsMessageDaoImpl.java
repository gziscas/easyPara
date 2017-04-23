package com.easycms.cms.dao.assist.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.easycms.cms.dao.assist.CmsMessageDao;
import com.easycms.cms.entity.assist.CmsMessage;
import com.easycms.common.hibernate4.Finder;
import com.easycms.common.hibernate4.HibernateBaseDao;
import com.easycms.common.page.Pagination;

public class CmsMessageDaoImpl extends HibernateBaseDao<CmsMessage, Integer>
		implements CmsMessageDao {

	public Pagination getPage(Integer siteId, Integer sendUserId,
			Integer receiverUserId, String title, Date sendBeginTime,
			Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
			int pageNo, int pageSize) {
		Finder finder=createFinder(siteId, sendUserId, receiverUserId, 
				title, sendBeginTime, sendEndTime,status, box, cacheable);
		return find(finder, pageNo, pageSize);
	}
	
	public List<CmsMessage> getList(Integer siteId, Integer sendUserId,
			Integer receiverUserId, String title, Date sendBeginTime,
			Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
			Integer first, Integer count){
		Finder finder=createFinder(siteId, sendUserId, receiverUserId, 
				title, sendBeginTime, sendEndTime,status, box, cacheable);
		if(first!=null){
			finder.setFirstResult(first);
		}
		if(count!=null){
			finder.setMaxResults(count);
		}
		return find(finder);
	}
	
	
	public CmsMessage findById(Integer id) {
		return super.get(id);
	}

	public CmsMessage save(CmsMessage bean) {
		getSession().save(bean);
		return bean;
	}
	
	public CmsMessage update(CmsMessage bean){
		getSession().update(bean);
		return bean;
	}

	public CmsMessage deleteById(Integer id) {
		CmsMessage entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	public CmsMessage[] deleteByIds(Integer[] ids) {
		CmsMessage[] messages = new CmsMessage[ids.length];
		for (int i = 0; i < ids.length; i++) {
			messages[i] = get(ids[i]);
			deleteById(ids[i]);
		}
		return messages;
	}
	
	private Finder createFinder(Integer siteId, Integer sendUserId,
			Integer receiverUserId, String title, Date sendBeginTime,
			Date sendEndTime, Boolean status, Integer box, Boolean cacheable){
		String hql = " select msg from CmsMessage msg where 1=1 ";
		Finder finder = Finder.create(hql);
		if (siteId != null) {
			finder.append(" and msg.site.id=:siteId")
					.setParam("siteId", siteId);
		}
		if(sendUserId != null&&receiverUserId != null){
			finder.append(" and (msg.msgSendUser.id=:sendUserId or msg.msgReceiverUser.id=:receiverUserId)").setParam(
					"sendUserId", sendUserId).setParam("receiverUserId", receiverUserId);
		}else{
			if (sendUserId != null) {
				finder.append(" and msg.msgSendUser.id=:sendUserId").setParam(
						"sendUserId", sendUserId);
			}
			if (receiverUserId != null) {
				finder.append(" and msg.msgReceiverUser.id=:receiverUserId")
						.setParam("receiverUserId", receiverUserId);
			}
		}
		
		if (StringUtils.isNotBlank(title)) {
			finder.append(" and msg.msgTitle like:title").setParam("title",
					"%" + title + "%");
		}
		if (sendBeginTime != null) {
			finder.append(" and msg.sendTime >=:sendBeginTime").setParam(
					"sendBeginTime", sendBeginTime);
		}
		if (sendEndTime != null) {
			finder.append(" and msg.sendTime <=:sendEndTime").setParam(
					"sendEndTime", sendEndTime);
		}
		if (status != null) {
			if (status) {
				finder.append(" and msg.msgStatus =true");
			} else {
				finder.append(" and msg.msgStatus =false");
			}
		}
		if (box != null) {
			finder.append(" and msg.msgBox =:box").setParam("box", box);
		}
		finder.append(" order by msg.id desc");
		return finder;
	}


	@Override
	protected Class<CmsMessage> getEntityClass() {
		return CmsMessage.class;
	}

}
