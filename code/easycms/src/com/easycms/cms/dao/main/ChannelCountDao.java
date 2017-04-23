package com.easycms.cms.dao.main;

import net.sf.ehcache.Ehcache;

import com.easycms.cms.entity.main.ChannelCount;
import com.easycms.common.hibernate4.Updater;

public interface ChannelCountDao {
	public int clearCount(boolean week, boolean month);
	
	public int clearContentCount(boolean day,boolean week, boolean month,boolean year);

	public int freshCacheToDB(Ehcache cache);

	public ChannelCount findById(Integer id);

	public ChannelCount save(ChannelCount bean);

	public ChannelCount updateByUpdater(Updater<ChannelCount> updater);
}