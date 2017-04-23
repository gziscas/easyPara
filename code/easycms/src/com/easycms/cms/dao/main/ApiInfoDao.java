package com.easycms.cms.dao.main;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;
import com.easycms.cms.entity.main.ApiInfo;

public interface ApiInfoDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public ApiInfo findByUrl(String url);

	public ApiInfo findById(Integer id);

	public ApiInfo save(ApiInfo bean);

	public ApiInfo updateByUpdater(Updater<ApiInfo> updater);

	public ApiInfo deleteById(Integer id);
}