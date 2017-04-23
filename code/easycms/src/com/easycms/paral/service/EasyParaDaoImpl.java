package com.easycms.paral.service;

import com.easycms.cms.dao.main.ChannelDao;
import com.easycms.cms.entity.main.Channel;
import com.easycms.common.hibernate4.Finder;
import com.easycms.common.hibernate4.HibernateBaseDao;
import com.easycms.common.hibernate4.Updater;
import com.easycms.core.entity.CmsUser;
import com.easycms.paral.entity.ParaTask;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EasyParaDaoImpl extends HibernateBaseDao<ParaTask, Integer> implements EasyParaDao {
    @Override
    protected Class<ParaTask> getEntityClass() {
        return ParaTask.class;
    }

    public ParaTask findById(Integer id) {
        ParaTask task = get(id);
        return task;
    }

    @Override
    public ParaTask save(ParaTask bean) {
        getSession().save(bean);
        return bean;
    }

    @Override
    public ParaTask updateTask(ParaTask bean) {
        Updater<ParaTask> updater=new Updater<ParaTask>(bean);
        updateByUpdater(updater);
        getSession().flush();
        return bean;
    }

    @Override
    public ParaTask deleteById(Integer id) {
        ParaTask entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        getSession().flush();
        return null;
    }

    @Override
    public List<ParaTask> getLists(CmsUser user) {
        Finder f = Finder.create("select bean from ParaTask bean");
        f.append(" where 1=1 ");
        if (user != null) {
            f.append(" and bean.member_id<=:member_id");
            f.setParam("member_id", user.getId());
        }
        f.append(" order by bean.sdate asc");
        return find(f);
    }
}
