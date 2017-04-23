package com.easycms.cms.dao.assist.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.easycms.common.hibernate4.HibernateBaseDao;
import com.easycms.common.page.Pagination;
import com.easycms.cms.dao.assist.CmsConfigContentChargeDao;
import com.easycms.cms.entity.assist.CmsConfigContentCharge;

@Repository
public class CmsConfigContentChargeDaoImpl extends HibernateBaseDao<CmsConfigContentCharge, Integer> implements CmsConfigContentChargeDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public CmsConfigContentCharge findById(Integer id) {
		CmsConfigContentCharge entity = get(id);
		return entity;
	}

	public CmsConfigContentCharge save(CmsConfigContentCharge bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsConfigContentCharge deleteById(Integer id) {
		CmsConfigContentCharge entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CmsConfigContentCharge> getEntityClass() {
		return CmsConfigContentCharge.class;
	}
}