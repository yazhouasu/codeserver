package com.hbgc.springbootdemo.service.imp;

import com.hbgc.springbootdemo.domain.Items;
import com.hbgc.springbootdemo.repository.ItemsRepository;
import com.hbgc.springbootdemo.service.ItemsService;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl extends BaseServiceImpl<Items,Integer, ItemsRepository> implements ItemsService {
}
