package com.easycms.cms.dao.main;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;

import java.util.List;

import com.easycms.cms.entity.main.ContentRecord;

public interface ContentRecordDao {
	public Pagination getPage(int pageNo, int pageSize);

	public ContentRecord findById(Long id);

	public ContentRecord save(ContentRecord bean);

	public ContentRecord updateByUpdater(Updater<ContentRecord> updater);

	public ContentRecord deleteById(Long id);

	public List<ContentRecord> getListByContentId(Integer contentId);
}