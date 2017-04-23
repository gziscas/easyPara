package com.easycms.cms.dao.assist;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;

import java.util.Date;
import java.util.List;

import com.easycms.cms.entity.assist.CmsAccountDraw;

public interface CmsAccountDrawDao {
	public Pagination getPage(Integer userId,Short applyStatus,
			Date applyTimeBegin,Date applyTimeEnd,int pageNo, int pageSize);
	
	public List<CmsAccountDraw> getList(Integer userId,Short applyStatus,
			Date applyTimeBegin,Date applyTimeEnd,Integer first,Integer count);
	
	public List<CmsAccountDraw> getList(Integer userId,Short[] status,Integer count);

	public CmsAccountDraw findById(Integer id);

	public CmsAccountDraw save(CmsAccountDraw bean);

	public CmsAccountDraw updateByUpdater(Updater<CmsAccountDraw> updater);

	public CmsAccountDraw deleteById(Integer id);
}