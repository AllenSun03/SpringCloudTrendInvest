package com.allen.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Author: AllenSun
 * @Date: 2020/4/11 11:18
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced//赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
