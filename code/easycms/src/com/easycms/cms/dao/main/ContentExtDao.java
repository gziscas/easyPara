package com.easycms.cms.dao.main;

import com.easycms.cms.entity.main.ContentExt;
import com.easycms.common.hibernate4.Updater;

public interface ContentExtDao {
	public ContentExt findById(Integer id);

	public ContentExt save(ContentExt bean);

	public ContentExt updateByUpdater(Updater<ContentExt> updater);
}