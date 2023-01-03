package com.example.wuyou.config;

import com.example.wuyou.aop.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        registry.addInterceptor(tokenInterceptor())//添加不拦截的请求路径
                .excludePathPatterns("/user/getOpenId","/user/wxUserLogin","/swagger-ui.html/**","/swagger-resources/**")
                .addPathPatterns("/**");						//添加需要拦截的路径
    }

    @Bean
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }
}
