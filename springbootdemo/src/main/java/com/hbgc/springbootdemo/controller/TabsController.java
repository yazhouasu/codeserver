package com.hbgc.springbootdemo.controller;

import com.hbgc.springbootdemo.domain.Tabs;
import com.hbgc.springbootdemo.json.Json;
import com.hbgc.springbootdemo.service.TabsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tabs")
public class TabsController extends BaseController {

    @Resource
    private TabsService tabsService;

    @GetMapping("/")
    @ApiOperation(value = "查询所有tabs标签接口", notes = "查询所有tabs标签资料")
    public Map<String, Object> queryAllTabs() {
        List<Tabs> tabsList;
        try {
            tabsList = tabsService.findAll();
            return Json.success(tabsList, "查询板块资料成功");

        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("查询板块资料失败");
        }
    }
}
