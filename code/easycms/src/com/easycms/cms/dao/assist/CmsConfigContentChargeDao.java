package com.easycms.cms.dao.assist;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;
import com.easycms.cms.entity.assist.CmsConfigContentCharge;

public interface CmsConfigContentChargeDao {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsConfigContentCharge findById(Integer id);

	public CmsConfigContentCharge save(CmsConfigContentCharge bean);

	public CmsConfigContentCharge updateByUpdater(Updater<CmsConfigContentCharge> updater);

	public CmsConfigContentCharge deleteById(Integer id);
}