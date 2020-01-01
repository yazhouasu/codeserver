package com.hbgc.springbootdemo.controller;

import com.hbgc.springbootdemo.domain.Items;
import com.hbgc.springbootdemo.json.Json;
import com.hbgc.springbootdemo.service.ItemsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("items")
public class ItemsController extends BaseController {

    @Resource
    private ItemsService itemsService;


    @GetMapping("/")
    @ApiOperation(value = "查询所有商品资料接口", notes = "查询所有商品资料")
    //@ApiImplicitParam(name = "token", value = "token值", required = true)
    public Map<String, Object> queryAllItems() {
        List<Items> itemsList = null;
        try {
            itemsList = itemsService.findAll();
            return Json.success(itemsList, "查询商品资料成功！");

        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("查询商品资料失败！");
        }
    }
}
