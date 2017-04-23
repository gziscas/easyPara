package com.easycms.cms.manager.main;

import com.easycms.common.page.Pagination;
import com.easycms.cms.entity.main.ApiRecord;

public interface ApiRecordMng {
	public Pagination getPage(int pageNo, int pageSize);

	public ApiRecord findById(Long id);
	
	public ApiRecord findBySign(String sign,String appId);
	
	public ApiRecord callApiRecord(String ip,String appId,String apiUrl,String sign);

	public ApiRecord save(ApiRecord bean);

	public ApiRecord update(ApiRecord bean);

	public ApiRecord deleteById(Long id);
	
	public ApiRecord[] deleteByIds(Long[] ids);
}