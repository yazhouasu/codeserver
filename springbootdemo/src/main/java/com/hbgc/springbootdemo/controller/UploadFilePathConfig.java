package com.hbgc.springbootdemo.controller;

import com.hbgc.springbootdemo.util.MyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//上传文件路径配置类
@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer {

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${upload.win.path}")
    private String uploadWinFolder;

    @Value("${upload.linux.path}")
    private String uploadLinuxFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if("windows".equals(MyUtils.getOperateSysName())) {
            registry.addResourceHandler(staticAccessPath).addResourceLocations("file:///" + uploadWinFolder);
            System.out.println("in UploadFilePathConfig,系统是windows");
        }else{
            registry.addResourceHandler(staticAccessPath).addResourceLocations("file:///" + uploadLinuxFolder);
            System.out.println("in UploadFilePathConfig,系统是linux");
        }
    }

}
