package com.easycms.cms.dao.main;

import com.easycms.cms.entity.main.ContentCheck;
import com.easycms.common.hibernate4.Updater;

public interface ContentCheckDao {
	public ContentCheck findById(Long id);

	public ContentCheck save(ContentCheck bean);

	public ContentCheck updateByUpdater(Updater<ContentCheck> updater);
}