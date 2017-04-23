package com.easycms.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.easycms.common.hibernate4.HibernateBaseDao;
import com.easycms.core.dao.CmsConfigDao;
import com.easycms.core.entity.CmsConfig;

@Repository
public class CmsConfigDaoImpl extends HibernateBaseDao<CmsConfig, Integer>
		implements CmsConfigDao {
	public CmsConfig findById(Integer id) {
		CmsConfig entity = get(id);
		return entity;
	}

	@Override
	protected Class<CmsConfig> getEntityClass() {
		return CmsConfig.class;
	}
}