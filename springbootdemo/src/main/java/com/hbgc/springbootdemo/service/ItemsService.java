package com.hbgc.springbootdemo.service;

import com.hbgc.springbootdemo.domain.Items;
import com.hbgc.springbootdemo.repository.ItemsRepository;

public interface ItemsService extends BaseService<Items,Integer, ItemsRepository> {
}
