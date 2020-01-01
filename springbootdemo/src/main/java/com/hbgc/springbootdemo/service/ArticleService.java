package com.hbgc.springbootdemo.service;

import com.hbgc.springbootdemo.domain.Article;
import com.hbgc.springbootdemo.repository.ArticleRepository;
import com.hbgc.springbootdemo.service.BaseService;

import java.util.List;

public interface ArticleService extends BaseService<Article,Integer, ArticleRepository>  {

    List<Article> findArticle(String type);
}
