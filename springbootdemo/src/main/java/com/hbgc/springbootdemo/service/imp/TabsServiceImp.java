package com.hbgc.springbootdemo.service.imp;

import com.hbgc.springbootdemo.domain.Tabs;
import com.hbgc.springbootdemo.repository.TabsRepository;
import com.hbgc.springbootdemo.service.TabsService;
import org.springframework.stereotype.Service;

@Service
public class TabsServiceImp extends BaseServiceImpl<Tabs,Integer, TabsRepository> implements TabsService {
}
