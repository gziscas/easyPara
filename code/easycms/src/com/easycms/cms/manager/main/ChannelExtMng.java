package com.easycms.cms.manager.main;

import com.easycms.cms.entity.main.Channel;
import com.easycms.cms.entity.main.ChannelExt;

public interface ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel);

	public ChannelExt update(ChannelExt ext);
}