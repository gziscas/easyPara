package com.easycms.plug.weixin.dao.impl;

import java.util.List;

import com.easycms.common.hibernate4.Finder;
import com.easycms.common.hibernate4.HibernateBaseDao;
import com.easycms.common.page.Pagination;
import com.easycms.plug.weixin.dao.WeixinDao;
import com.easycms.plug.weixin.entity.Weixin;

public class WeixinDaoImpl extends HibernateBaseDao<Weixin, Integer> implements WeixinDao{
	
	public Pagination getPage(Integer siteId,int pageNo,int pageSize){
		Finder f = Finder.create(" from Weixin bean where 1=1");
		f.append(" and bean.site.id=:siteId");
		f.setParam("siteId", siteId);
		return find(f,pageNo,pageSize);
	}
	
	public Weixin findById(Integer id){
		return get(id);
	}
	
	public Weixin find(Integer siteId){
		Finder f = Finder.create(" from Weixin bean where 1=1");
		f.append(" and bean.site.id=:siteId").setParam("siteId", siteId);
		List<Weixin> list = find(f);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public Weixin deleteById(Integer id){
		Weixin entity = get(id);
		if(entity!=null){
			getSession().delete(entity);
			return entity;
		}
		return null;
	}
	
	public Weixin save(Weixin bean){
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<Weixin> getEntityClass() {
		return Weixin.class;
	}

}
