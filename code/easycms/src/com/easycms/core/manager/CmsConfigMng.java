package com.easycms.core.manager;

import java.util.Date;
import java.util.Map;

import com.easycms.core.entity.CmsConfig;
import com.easycms.core.entity.CmsConfigAttr;
import com.easycms.core.entity.MarkConfig;
import com.easycms.core.entity.MemberConfig;

public interface CmsConfigMng {
	public CmsConfig get();
	
	public Integer getContentFreshMinute();

	public void updateCountCopyTime(Date d);

	public void updateCountClearTime(Date d);
	
	public void updateFlowClearTime(Date d);
	
	public void updateChannelCountClearTime(Date d);

	public CmsConfig update(CmsConfig bean);

	public MarkConfig updateMarkConfig(MarkConfig mark);

	public void updateMemberConfig(MemberConfig memberConfig);
	
	public void updateConfigAttr(CmsConfigAttr configAttr);
	
	public void updateSsoAttr(Map<String,String> ssoAttr);
	
	public void updateRewardFixAttr(Map<String,String> fixAttr);
}