package com.xingxing.user;

import com.xingxing.user.utils.JwtUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import util.IdWorker;

@EnableCaching //开启SpringCache缓存
@SpringBootApplication
@MapperScan("com.xingxing.user.dao")
public class UserAppilcation {
    public static void main(String[] args) {

        SpringApplication.run(UserAppilcation.class);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }



    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtUtil jwtUtil(){
        return  new JwtUtil();
    }

}
