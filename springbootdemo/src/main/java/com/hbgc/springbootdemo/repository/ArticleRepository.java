package com.hbgc.springbootdemo.repository;

import com.hbgc.springbootdemo.domain.Article;

import java.util.List;

public interface ArticleRepository extends BaseRepository<Article,Integer> {
    List<Article> findArticleByType(String type);//通过id查找文章
}
