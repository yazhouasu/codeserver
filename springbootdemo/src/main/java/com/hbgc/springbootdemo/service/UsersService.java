package com.hbgc.springbootdemo.service;

import com.hbgc.springbootdemo.domain.Users;
import com.hbgc.springbootdemo.repository.UsersRepository;

public interface UsersService extends BaseService<Users,Integer, UsersRepository> {

    public Users login(String username, String password);

    public Users findMobile(String mobile);

}
