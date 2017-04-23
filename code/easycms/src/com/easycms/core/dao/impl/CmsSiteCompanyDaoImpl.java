package com.easycms.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.easycms.common.hibernate4.HibernateBaseDao;
import com.easycms.core.dao.CmsSiteCompanyDao;
import com.easycms.core.entity.CmsSiteCompany;

@Repository
public class CmsSiteCompanyDaoImpl extends
		HibernateBaseDao<CmsSiteCompany, Integer> implements CmsSiteCompanyDao {

	public CmsSiteCompany save(CmsSiteCompany bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<CmsSiteCompany> getEntityClass() {
		return CmsSiteCompany.class;
	}
}