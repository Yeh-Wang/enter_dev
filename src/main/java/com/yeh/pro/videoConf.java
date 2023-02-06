package com.yeh.pro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Yaxin-Wang
 * @date : 2023/2/3
 */
@Configuration
public class videoConf implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/yeh/**")
                .addResourceLocations("file:///D:/looker/Video/");
    }
}
//设置虚拟路径
//例如D:/looker/Video/123.mp4 视频资源
//在此配置后使用http://localhost:9090/yeh/123.mp4,也可以打开
//因此数据库中视频资源的存储方式为http://localhost:9090/yeh/视频资源.mp4
