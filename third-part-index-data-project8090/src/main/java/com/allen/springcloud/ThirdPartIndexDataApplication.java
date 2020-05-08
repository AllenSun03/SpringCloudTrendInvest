package com.allen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: ThirdPartIndexDataApplication
 * @Author: AllenSun
 * @Date: 2020/4/12 1:19
 */
@SpringBootApplication
@EnableEurekaClient
public class ThirdPartIndexDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThirdPartIndexDataApplication.class, args);
    }
}
