package com.easycms.cms.manager.main;

import com.easycms.common.page.Pagination;
import com.easycms.cms.entity.main.ApiInfo;

public interface ApiInfoMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public ApiInfo findByUrl(String url);

	public ApiInfo findById(Integer id);

	public ApiInfo save(ApiInfo bean);

	public ApiInfo update(ApiInfo bean);

	public ApiInfo deleteById(Integer id);
	
	public ApiInfo[] deleteByIds(Integer[] ids);
}