package com.awssd.demo.test;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 创建java类继承WebMvcConfigurerAdapter类，重写addInterceptors方法
 * @author LingDu
 */
@Configuration
public class InterceptorConfigurerAdapter extends WebMvcConfigurationSupport {
    /**
     * 该方法用于注册拦截器
     * 可注册多个拦截器，多个拦截器组成一个拦截器链
     */
    @Bean
    public Loiterer  getLoiterer() {
        return new Loiterer();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 添加路径
        // excludePathPatterns 排除路径
        registry.addInterceptor(getLoiterer()).addPathPatterns("/*/**");

    }
}
