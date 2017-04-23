package com.easycms.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.easycms.cms.dao.main.ContentTxtDao;
import com.easycms.cms.entity.main.ContentTxt;
import com.easycms.common.hibernate4.HibernateBaseDao;

@Repository
public class ContentTxtDaoImpl extends HibernateBaseDao<ContentTxt, Integer>
		implements ContentTxtDao {
	public ContentTxt findById(Integer id) {
		ContentTxt entity = get(id);
		return entity;
	}

	public ContentTxt save(ContentTxt bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<ContentTxt> getEntityClass() {
		return ContentTxt.class;
	}
}