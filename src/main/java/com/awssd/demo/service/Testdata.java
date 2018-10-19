package com.awssd.demo.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Testdata {
    @Bean(name="restTemplate")
    public int Data()
    {
        return 12;

    }
}
