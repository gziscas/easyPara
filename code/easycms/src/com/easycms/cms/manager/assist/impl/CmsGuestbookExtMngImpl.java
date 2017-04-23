package com.easycms.cms.manager.assist.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycms.cms.dao.assist.CmsGuestbookExtDao;
import com.easycms.cms.entity.assist.CmsGuestbook;
import com.easycms.cms.entity.assist.CmsGuestbookExt;
import com.easycms.cms.manager.assist.CmsGuestbookExtMng;
import com.easycms.common.hibernate4.Updater;

@Service
@Transactional
public class CmsGuestbookExtMngImpl implements CmsGuestbookExtMng {
	public CmsGuestbookExt save(CmsGuestbookExt ext, CmsGuestbook guestbook) {
		guestbook.setExt(ext);
		ext.setGuestbook(guestbook);
		ext.init();
		dao.save(ext);
		return ext;
	}

	public CmsGuestbookExt update(CmsGuestbookExt ext) {
		Updater<CmsGuestbookExt> updater = new Updater<CmsGuestbookExt>(ext);
		CmsGuestbookExt entity = dao.updateByUpdater(updater);
		entity.blankToNull();
		return entity;
	}

	private CmsGuestbookExtDao dao;

	@Autowired
	public void setDao(CmsGuestbookExtDao dao) {
		this.dao = dao;
	}
}