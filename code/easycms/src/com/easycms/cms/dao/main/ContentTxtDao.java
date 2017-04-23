package com.easycms.cms.dao.main;

import com.easycms.cms.entity.main.ContentTxt;
import com.easycms.common.hibernate4.Updater;

public interface ContentTxtDao {
	public ContentTxt findById(Integer id);

	public ContentTxt save(ContentTxt bean);

	public ContentTxt updateByUpdater(Updater<ContentTxt> updater);
}