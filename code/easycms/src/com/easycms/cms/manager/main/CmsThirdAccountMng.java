package com.easycms.cms.manager.main;

import com.easycms.common.page.Pagination;
import com.easycms.cms.entity.main.CmsThirdAccount;

public interface CmsThirdAccountMng {
	public Pagination getPage(String username,String source,int pageNo, int pageSize);

	public CmsThirdAccount findById(Long id);
	
	public CmsThirdAccount findByKey(String key);

	public CmsThirdAccount save(CmsThirdAccount bean);

	public CmsThirdAccount update(CmsThirdAccount bean);

	public CmsThirdAccount deleteById(Long id);
	
	public CmsThirdAccount[] deleteByIds(Long[] ids);
}