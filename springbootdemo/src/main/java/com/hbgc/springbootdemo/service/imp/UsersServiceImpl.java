package com.hbgc.springbootdemo.service.imp;

import com.hbgc.springbootdemo.domain.Users;
import com.hbgc.springbootdemo.repository.UsersRepository;
import com.hbgc.springbootdemo.service.UsersService;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl extends BaseServiceImpl<Users,Integer, UsersRepository> implements UsersService {

    @Override
    public Users login(String username, String password) {
        return super.dao.findByUsernameAndPassword(username,password);
    }

    @Override
    public Users findMobile(String mobile) {
        return super.dao.findUsersByMobile(mobile);
    }
}
