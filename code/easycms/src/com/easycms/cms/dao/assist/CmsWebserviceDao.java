package com.easycms.cms.dao.assist;

import java.util.List;

import com.easycms.cms.entity.assist.CmsWebservice;
import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;

public interface CmsWebserviceDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsWebservice> getList(String type);

	public CmsWebservice findById(Integer id);

	public CmsWebservice save(CmsWebservice bean);

	public CmsWebservice updateByUpdater(Updater<CmsWebservice> updater);

	public CmsWebservice deleteById(Integer id);
}