package com.easycms.cms.dao.main;

import java.util.List;

import com.easycms.cms.entity.main.CmsModel;
import com.easycms.common.hibernate4.Updater;

public interface CmsModelDao {
	public List<CmsModel> getList(boolean containDisabled,Boolean hasContent,Integer siteId);

	public CmsModel getDefModel();

	public CmsModel findById(Integer id);
	
	public CmsModel findByPath(String path);

	public CmsModel save(CmsModel bean);

	public CmsModel updateByUpdater(Updater<CmsModel> updater);

	public CmsModel deleteById(Integer id);
}