package com.easycms.cms.dao.main;

import com.easycms.cms.entity.main.ChannelTxt;
import com.easycms.common.hibernate4.Updater;

public interface ChannelTxtDao {
	public ChannelTxt findById(Integer id);

	public ChannelTxt save(ChannelTxt bean);

	public ChannelTxt updateByUpdater(Updater<ChannelTxt> updater);
}