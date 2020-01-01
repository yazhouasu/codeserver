package com.hbgc.springbootdemo.controller;

import com.hbgc.springbootdemo.util.MyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

//上传文件大小配置类
@Configuration
public class UploadFileConfig {

    @Value("${upload.win.path}")
    private String uploadWinFolder;

    @Value("${upload.linux.path}")
    private String uploadLinuxFolder;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        if("windows".equals(MyUtils.getOperateSysName())) {
            factory.setLocation(uploadWinFolder);
        }else{
            factory.setLocation(uploadLinuxFolder);
        }
        //文件最大
        factory.setMaxFileSize(DataSize.ofMegabytes(50)); //上传的单个文件不能超过50M
        //设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(500)); //上传文件的总大小不能超过500M
        return factory.createMultipartConfig();
    }
}
