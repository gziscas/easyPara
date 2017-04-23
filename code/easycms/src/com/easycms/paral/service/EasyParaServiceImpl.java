package com.easycms.paral.service;

import com.easycms.common.hibernate4.Updater;
import com.easycms.core.entity.CmsUser;
import com.easycms.paral.entity.ParaTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EasyParaServiceImpl implements EasyParaService {
    EasyParaDao easyParaDao;

    @Override
    public ParaTask save(ParaTask bean) {
        return easyParaDao.save(bean);
    }

    @Override
    public ParaTask updateTask(ParaTask bean) {
        Updater<ParaTask> updater=new Updater<ParaTask>(bean);
        return easyParaDao.updateTask(bean);
    }

    @Override
    public ParaTask deleteById(Integer id) {
        return easyParaDao.deleteById(id);
    }

    @Override
    public List<ParaTask> getLists(CmsUser user) {
        return easyParaDao.getLists(user);
    }

    @Override
    public ParaTask findById(Integer id) {
        return easyParaDao.findById(id);
    }

    @Autowired
    public void setEasyParaDao(EasyParaDao easyParaDao){
        this.easyParaDao = easyParaDao;
    }
}
