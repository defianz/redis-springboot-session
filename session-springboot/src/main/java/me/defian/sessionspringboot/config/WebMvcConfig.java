package me.defian.sessionspringboot.config;

import me.defian.sessionspringboot.intercepter.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig
        implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        SessionInterceptor sessionInterceptor = new SessionInterceptor();
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/session/members/login.do")
                .excludePathPatterns(" ","/","/error");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
