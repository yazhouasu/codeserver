package com.hbgc.springbootdemo.service.imp;

import com.hbgc.springbootdemo.domain.Article;
import com.hbgc.springbootdemo.repository.ArticleRepository;
import com.hbgc.springbootdemo.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImp extends BaseServiceImpl<Article,Integer, ArticleRepository>  implements ArticleService{
    @Override
    public List<Article> findArticle(String type) {
        return super.dao.findArticleByType(type);
    }
}
