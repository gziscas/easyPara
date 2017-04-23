package com.easycms.plug.store.dao;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;
import com.easycms.plug.store.entity.PlugStoreConfig;

public interface PlugStoreConfigDao {
	public Pagination getPage(int pageNo, int pageSize);

	public PlugStoreConfig findById(Integer id);

	public PlugStoreConfig save(PlugStoreConfig bean);

	public PlugStoreConfig updateByUpdater(Updater<PlugStoreConfig> updater);

	public PlugStoreConfig deleteById(Integer id);
}