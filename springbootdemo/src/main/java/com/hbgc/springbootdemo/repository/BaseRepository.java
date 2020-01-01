package com.hbgc.springbootdemo.repository;


import com.hbgc.springbootdemo.domain.BaseEntity;
import com.hbgc.springbootdemo.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *  @NoRepositoryBean 表示是所有业务逻辑接口的父类泛型接口
 * @param <T>  对应业务逻辑的类型
 * @param <ID>  业务逻辑类型的主键类型
 */

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity,ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor {

}
