package com.easycms.cms.dao.assist;

import java.util.List;

import com.easycms.cms.entity.assist.CmsAcquisitionTemp;
import com.easycms.common.hibernate4.Updater;

public interface CmsAcquisitionTempDao {
	public List<CmsAcquisitionTemp> getList(Integer siteId);

	public CmsAcquisitionTemp findById(Integer id);

	public CmsAcquisitionTemp save(CmsAcquisitionTemp bean);

	public CmsAcquisitionTemp updateByUpdater(Updater<CmsAcquisitionTemp> updater);

	public CmsAcquisitionTemp deleteById(Integer id);
	
	public Integer getPercent(Integer siteId);
	
	public void clear(Integer siteId,String channelUrl);
}