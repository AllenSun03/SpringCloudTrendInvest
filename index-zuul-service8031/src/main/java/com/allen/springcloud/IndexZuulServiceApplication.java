package com.allen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName: IndexZuulServiceApplication
 * @Author: AllenSun
 * @Date: 2020/4/12 14:35
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class IndexZuulServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(IndexZuulServiceApplication.class, args);
    }

    // @Bean
    // public Sampler defaultSampler() {
    //     return Sampler.ALWAYS_SAMPLE;
    // }
}
