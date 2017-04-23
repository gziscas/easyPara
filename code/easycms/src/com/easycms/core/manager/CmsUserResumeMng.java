package com.easycms.core.manager;

import com.easycms.core.entity.CmsUser;
import com.easycms.core.entity.CmsUserResume;

public interface CmsUserResumeMng {
	public CmsUserResume save(CmsUserResume ext, CmsUser user);

	public CmsUserResume update(CmsUserResume ext, CmsUser user);
}