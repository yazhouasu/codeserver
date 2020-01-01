package com.hbgc.springbootdemo.service;

import com.hbgc.springbootdemo.domain.BaseEntity;
import com.hbgc.springbootdemo.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T> 表示具体的类型
 * @param <I> 表示该类型的主键类型
 * @param <R> 表示该类型的Repository层的实现类型。
 */
public interface BaseService<T extends BaseEntity, I extends Serializable, R extends BaseRepository<T, I>> {

    //查询所有对象
    List<T> findAll();

    //根据主键查询单个对象。
    T getOne(I id);

    //查询分页记录。
    Page<T> findAllByPager(Pageable pageable);

    //添加单个对象
    void save(T obj);

    //修改单个对象
    void update(T obj);

    //根据主键删除单个对象。
    void deleteById(I id);


    //批量添加
    List<T> saveList(List<T> list);

    //批量删除
    void batchDelete(List<T> list);

}
