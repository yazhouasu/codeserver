package com.hbgc.springbootdemo.service;

import com.hbgc.springbootdemo.domain.Article;
import com.hbgc.springbootdemo.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleSeviceTest {
    @Resource
    private ArticleService articleService;

    @Resource
    private UsersService usersService;

    @Test
    public void testFindArticle() {
        List<Article> articleList = articleService.findArticle("数据库");
        System.out.println(articleList);
    }

    @Test
    public void testGetOne(){
        Article article=articleService.getOne(8);

        System.out.println(article);
        System.out.println(article.getContent());
    }

    @Test
    public void testsave(){
        Article article=new Article();
        articleService.save(article);

    }
    @Test
    public void testMobile(){
      Users users=  usersService.findMobile("15511061269");
        System.out.println(users);

    }
}
