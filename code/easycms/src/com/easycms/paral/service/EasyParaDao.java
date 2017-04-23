package com.easycms.paral.service;

import com.easycms.core.entity.CmsUser;
import com.easycms.paral.entity.ParaTask;

import java.util.List;

public interface EasyParaDao {

    public ParaTask findById(Integer id);

    public ParaTask save(ParaTask bean);

    public ParaTask updateTask(ParaTask bean);

    public ParaTask deleteById(Integer id);

    public List<ParaTask> getLists(CmsUser user);
}
