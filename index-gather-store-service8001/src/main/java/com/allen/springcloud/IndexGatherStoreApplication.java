package com.allen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: IndexGatherStoreApplication
 * @Author: AllenSun
 * @Date: 2020/4/12 1:41
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix//启动断路器
@EnableCaching//启动缓存
public class IndexGatherStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndexGatherStoreApplication.class,args);
    }

    //不加这个导致数据加不进redis
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
