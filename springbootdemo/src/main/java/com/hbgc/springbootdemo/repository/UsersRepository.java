package com.hbgc.springbootdemo.repository;

import com.hbgc.springbootdemo.domain.Users;

public interface UsersRepository extends BaseRepository<Users,Integer> {

    //通过用户名和密码查找并返回用户对象
    Users findByUsernameAndPassword(String username, String password);
    //通过手机号查找是否有这个用户
    Users findUsersByMobile(String mobile);
}
