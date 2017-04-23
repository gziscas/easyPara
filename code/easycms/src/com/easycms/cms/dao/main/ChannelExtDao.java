package com.easycms.cms.dao.main;

import com.easycms.cms.entity.main.ChannelExt;
import com.easycms.common.hibernate4.Updater;

public interface ChannelExtDao {
	public ChannelExt save(ChannelExt bean);

	public ChannelExt updateByUpdater(Updater<ChannelExt> updater);
}