package com.zhangbin.jpa.configuration;

import com.zhangbin.jpa.Interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * mark
 *
 * @Author: zhangbin
 * @Date: 2019-01-21 21:44
 * @Version 1.0
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
