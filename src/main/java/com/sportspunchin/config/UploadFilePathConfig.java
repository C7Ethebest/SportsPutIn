package com.sportspunchin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin
@Component
@Configuration
//传输文件工具
public class UploadFilePathConfig implements WebMvcConfigurer {

    @Value("${file.staticAccessPath:DefaultValue}")
    private String staticAccessPath;

    @Value("${file. uploadFolder:DefaultValue}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
        }
    }