package com.allen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: TrendTradingBackTestServiceApplication8051
 * @Author: AllenSun
 * @Date: 2020/5/1 0:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class TrendTradingBackTestServiceApplication8051 {
    public static void main(String[] args) {
        SpringApplication.run(TrendTradingBackTestServiceApplication8051.class,args);
    }

    // @Bean
    // public Sampler defaultSampler() {
    //     return Sampler.ALWAYS_SAMPLE;
    // }
}
