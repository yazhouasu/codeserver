package com.hbgc.springbootdemo.controller;

import com.hbgc.springbootdemo.domain.Article;
import com.hbgc.springbootdemo.domain.Items;
import com.hbgc.springbootdemo.json.Json;
import com.hbgc.springbootdemo.service.ArticleService;
import com.hbgc.springbootdemo.service.ItemsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Resource
    private ArticleService articleService;


    @GetMapping("cards")
    @ApiOperation(value = "查询所有文章接口", notes = "查询所有文章资料")
    public Map<String, Object> findArticle(String type) {
        List<Article> articleList=null;

        System.out.println("类型是：" + type);
        try {
            articleList = articleService.findArticle(type);
            if(articleList!=null){
                return Json.success(articleList, "查询文章成功！");
            }
            return Json.fail("查询文章失败！");

        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("文章不存在！");
        }
    }

    @GetMapping("content")
    @ApiOperation(value = "查询文章内容的接口", notes = "查询某个aid的文章资料")
    public Map<String, Object> getArticle(int aid) {

        Article article=null;
        try {
            article = articleService.getOne(aid);
            if(article!=null){
                return Json.success(article,"查询文章内容成功！" );
            }
            return Json.fail("查询文章内容失败！");

        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("文章内容不存在！");
        }
    }

    @PostMapping("save")
    @ApiOperation(value = "保存编辑的文章的接口", notes = "保存某个type的文章资料")
    public Map<String, Object> saveArticle(@RequestBody Article article) {

        try {
            articleService.save(article);
            if(article!=null){
                return Json.success(article,"保存文章内容成功！" );
            }
            return Json.fail("保存文章内容失败！");

        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("保存文章内容不存在！");
        }
    }
}
