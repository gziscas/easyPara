package com.easycms.cms.dao.main;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;
import com.easycms.cms.entity.main.ApiRecord;

public interface ApiRecordDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public ApiRecord findBySign(String sign,String appId);

	public ApiRecord findById(Long id);

	public ApiRecord save(ApiRecord bean);

	public ApiRecord updateByUpdater(Updater<ApiRecord> updater);

	public ApiRecord deleteById(Long id);
}