package com.easycms.cms.manager.assist;

import com.easycms.cms.entity.assist.CmsComment;
import com.easycms.cms.entity.assist.CmsCommentExt;

public interface CmsCommentExtMng {
	public CmsCommentExt save(String ip, String text, CmsComment comment);

	public CmsCommentExt update(CmsCommentExt bean);

	public int deleteByContentId(Integer contentId);
}