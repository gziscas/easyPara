package com.easycms.cms.manager.main;

import com.easycms.cms.entity.main.Content;
import com.easycms.cms.entity.main.ContentTxt;

public interface ContentTxtMng {
	public ContentTxt save(ContentTxt txt, Content content);

	public ContentTxt update(ContentTxt txt, Content content);
}