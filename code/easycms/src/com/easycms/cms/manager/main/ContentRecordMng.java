package com.easycms.cms.manager.main;

import com.easycms.common.page.Pagination;
import com.easycms.core.entity.CmsUser;

import java.util.List;

import com.easycms.cms.entity.main.Content;
import com.easycms.cms.entity.main.ContentRecord;
import com.easycms.cms.entity.main.ContentRecord.ContentOperateType;

public interface ContentRecordMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<ContentRecord>getListByContentId(Integer contentId);
	
	public ContentRecord record(Content content,CmsUser user,ContentOperateType operate);

	public ContentRecord findById(Long id);

	public ContentRecord save(ContentRecord bean);

	public ContentRecord update(ContentRecord bean);

	public ContentRecord deleteById(Long id);
	
	public ContentRecord[] deleteByIds(Long[] ids);
}