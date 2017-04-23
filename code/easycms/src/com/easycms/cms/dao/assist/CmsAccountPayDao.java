package com.easycms.cms.dao.assist;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;

import java.util.Date;

import com.easycms.cms.entity.assist.CmsAccountPay;

public interface CmsAccountPayDao {
	public Pagination getPage(String drawNum,Integer payUserId,Integer drawUserId,
			Date payTimeBegin,Date payTimeEnd,int pageNo, int pageSize);

	public CmsAccountPay findById(Long id);

	public CmsAccountPay save(CmsAccountPay bean);

	public CmsAccountPay updateByUpdater(Updater<CmsAccountPay> updater);

	public CmsAccountPay deleteById(Long id);
}