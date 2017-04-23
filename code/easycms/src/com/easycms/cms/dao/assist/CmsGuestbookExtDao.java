package com.easycms.cms.dao.assist;

import com.easycms.cms.entity.assist.CmsGuestbookExt;
import com.easycms.common.hibernate4.Updater;

public interface CmsGuestbookExtDao {
	public CmsGuestbookExt findById(Integer id);

	public CmsGuestbookExt save(CmsGuestbookExt bean);

	public CmsGuestbookExt updateByUpdater(Updater<CmsGuestbookExt> updater);

	public CmsGuestbookExt deleteById(Integer id);
}