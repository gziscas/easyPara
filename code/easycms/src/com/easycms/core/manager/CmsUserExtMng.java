package com.easycms.core.manager;

import com.easycms.core.entity.CmsUser;
import com.easycms.core.entity.CmsUserExt;

public interface CmsUserExtMng {
	public CmsUserExt findById(Integer userId);
	
	public CmsUserExt save(CmsUserExt ext, CmsUser user);

	public CmsUserExt update(CmsUserExt ext, CmsUser user);
}