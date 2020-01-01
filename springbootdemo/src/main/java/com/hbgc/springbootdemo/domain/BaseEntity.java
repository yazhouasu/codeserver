package com.hbgc.springbootdemo.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass//表示该类是所有实体类的父类,那么这个类的所有的属性都会映射到子类上，生成表里面的字段
public class BaseEntity {

    protected Integer version;//乐观锁
    @Column(length = 32)
    protected String createTime;//该记录的创建时间
    @Column(length = 32)
    protected String modifyTime;//该记录的最后一次修改时间
    @Column(insertable = false, columnDefinition = "boolean default false")
    protected boolean flag;//该记录是否是已经删除的记录

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
