package com.xingxing.user.config;


import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.testng.util.Strings;

import java.text.SimpleDateFormat;
import java.util.Date;


@Configuration
public class CrossDomain extends WebMvcConfigurerAdapter {

    /**
     * Created by zhiji on 2018/12/5.
     * 解决前端跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600);

    }
}
