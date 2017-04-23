package com.easycms.core.dao;

import com.easycms.common.hibernate4.Updater;
import com.easycms.core.entity.CmsConfig;

public interface CmsConfigDao {
	public CmsConfig findById(Integer id);

	public CmsConfig updateByUpdater(Updater<CmsConfig> updater);
}