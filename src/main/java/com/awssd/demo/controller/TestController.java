package com.awssd.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class TestController {
    @RequestMapping("/Indez")
    public String Test()
    {

        return "TestJsp";
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/Jsp/");
        resolver.setSuffix(".jsp");
        return resolver;

    }


}
