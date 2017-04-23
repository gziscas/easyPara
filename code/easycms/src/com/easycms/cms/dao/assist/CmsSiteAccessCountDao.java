package com.easycms.cms.dao.assist;

import java.util.Date;
import java.util.List;

import com.easycms.cms.entity.assist.CmsSiteAccessCount;
import com.easycms.common.hibernate4.Updater;

/**
 * @author Tom
 */
public interface CmsSiteAccessCountDao {

	public List<Object[]> statisticVisitorCountByDate(Integer siteId,Date begin,Date end);
	
	public List<Object[]> statisticVisitorCountByYear(Integer siteId,Integer year);

	public CmsSiteAccessCount save(CmsSiteAccessCount count);

	public CmsSiteAccessCount updateByUpdater(Updater<CmsSiteAccessCount> updater);

}
