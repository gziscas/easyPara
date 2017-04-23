package com.easycms.cms.manager.main;

import com.easycms.cms.entity.main.Content;
import com.easycms.cms.entity.main.ContentExt;

public interface ContentExtMng {
	public ContentExt save(ContentExt ext, Content content);

	public ContentExt update(ContentExt ext);
}