package com.hbgc.springbootdemo.service.imp;

import cn.hutool.core.date.DateTime;
import com.hbgc.springbootdemo.domain.BaseEntity;
import com.hbgc.springbootdemo.repository.BaseRepository;
import com.hbgc.springbootdemo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BaseServiceImpl<T extends BaseEntity, I extends Serializable, R extends BaseRepository<T, I>> implements BaseService<T, I, R> {

    @Autowired
    protected R dao;

    @Transactional
    @Override
    public List<T> findAll() {

        return dao.findAll();
    }

    @Transactional
    @Override
    public T getOne(I id) {
        return dao.getOne(id);
    }

    @Transactional
    @Override
    public Page<T> findAllByPager(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void save(T obj) {
        System.out.println("开始执行BaseServiceImpl-->save()");

        Date d = new Date();
        DateTime dt = DateTime.of(d);
        obj.setCreateTime(dt.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println("createTime is :"+obj.getCreateTime());
        dao.save(obj);

    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void update(T obj) {

        Date d = new Date();
        DateTime dt = DateTime.of(d);
        obj.setModifyTime(dt.toString("yyyy-MM-dd HH:mm:ss"));
        dao.save(obj);

    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteById(I id) {

        dao.deleteById(id);

    }

    @Override
    public List<T> saveList(List<T> list) {
        return dao.saveAll(list);
    }

    @Override
    public void batchDelete(List<T> list) {
        dao.deleteInBatch(list);
    }
}
