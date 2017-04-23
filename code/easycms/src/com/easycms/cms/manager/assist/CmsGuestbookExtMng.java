package com.easycms.cms.manager.assist;

import com.easycms.cms.entity.assist.CmsGuestbook;
import com.easycms.cms.entity.assist.CmsGuestbookExt;

public interface CmsGuestbookExtMng {
	public CmsGuestbookExt save(CmsGuestbookExt ext, CmsGuestbook guestbook);

	public CmsGuestbookExt update(CmsGuestbookExt ext);
}