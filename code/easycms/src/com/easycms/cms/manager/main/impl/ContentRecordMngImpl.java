package com.easycms.cms.manager.main.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycms.common.hibernate4.Updater;
import com.easycms.common.page.Pagination;
import com.easycms.core.entity.CmsUser;
import com.easycms.cms.dao.main.ContentRecordDao;
import com.easycms.cms.entity.main.Content;
import com.easycms.cms.entity.main.ContentRecord;
import com.easycms.cms.entity.main.ContentRecord.ContentOperateType;
import com.easycms.cms.manager.main.ContentRecordMng;

@Service
@Transactional
public class ContentRecordMngImpl implements ContentRecordMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<ContentRecord>getListByContentId(Integer contentId){
		return dao.getListByContentId(contentId);
	}

	@Transactional(readOnly = true)
	public ContentRecord findById(Long id) {
		ContentRecord entity = dao.findById(id);
		return entity;
	}
	
	public ContentRecord record(Content content,CmsUser user,ContentOperateType operate){
		ContentRecord record=new ContentRecord();
		record.setContent(content);
		record.setOperateTime(Calendar.getInstance().getTime());
		record.setUser(user);
		Byte operateByte = ContentRecord.add;
		if(operate==ContentOperateType.edit){
			operateByte=ContentRecord.edit;
		}else if(operate==ContentOperateType.cycle){
			operateByte=ContentRecord.cycle;
		}else if(operate==ContentOperateType.check){
			operateByte=ContentRecord.check;
		}else if(operate==ContentOperateType.rejected){
			operateByte=ContentRecord.rejected;
		}else if(operate==ContentOperateType.move){
			operateByte=ContentRecord.move;
		}else if(operate==ContentOperateType.shared){
			operateByte=ContentRecord.shared;
		}else if(operate==ContentOperateType.pigeonhole){
			operateByte=ContentRecord.pigeonhole;
		}else if(operate==ContentOperateType.reuse){
			operateByte=ContentRecord.reuse;
		}else if(operate==ContentOperateType.createPage){
			operateByte=ContentRecord.createPage;
		}
		record.setOperateType(operateByte);
		save(record);
		return record;
	}

	public ContentRecord save(ContentRecord bean) {
		dao.save(bean);
		return bean;
	}

	public ContentRecord update(ContentRecord bean) {
		Updater<ContentRecord> updater = new Updater<ContentRecord>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public ContentRecord deleteById(Long id) {
		ContentRecord bean = dao.deleteById(id);
		return bean;
	}
	
	public ContentRecord[] deleteByIds(Long[] ids) {
		ContentRecord[] beans = new ContentRecord[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ContentRecordDao dao;

	@Autowired
	public void setDao(ContentRecordDao dao) {
		this.dao = dao;
	}
}