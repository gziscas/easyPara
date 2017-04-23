package com.easycms.cms.dao.assist;

import java.util.List;

import com.easycms.cms.entity.assist.CmsSensitivity;
import com.easycms.common.hibernate4.Updater;

public interface CmsSensitivityDao {
	public List<CmsSensitivity> getList(boolean cacheable);

	public CmsSensitivity findById(Integer id);

	public CmsSensitivity save(CmsSensitivity bean);

	public CmsSensitivity updateByUpdater(Updater<CmsSensitivity> updater);

	public CmsSensitivity deleteById(Integer id);
}