package com.easycms.cms.dao.assist;

import java.util.List;

import com.easycms.cms.entity.assist.CmsAcquisitionHistory;
import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;

public interface CmsAcquisitionHistoryDao {
	public List<CmsAcquisitionHistory> getList(Integer siteId,Integer acquId);

	public Pagination getPage(Integer siteId,Integer acquId, Integer pageNo, Integer pageSize);

	public CmsAcquisitionHistory findById(Integer id);

	public CmsAcquisitionHistory save(CmsAcquisitionHistory bean);

	public CmsAcquisitionHistory updateByUpdater(Updater<CmsAcquisitionHistory> updater);

	public CmsAcquisitionHistory deleteById(Integer id);
	
	public void deleteByAcquisition(Integer acquId);

	public Boolean checkExistByProperties(Boolean title, String value);
}