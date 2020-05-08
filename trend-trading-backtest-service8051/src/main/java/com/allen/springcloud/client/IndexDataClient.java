package com.allen.springcloud.client;

import com.allen.springcloud.pojo.IndexData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName: IndexDataClient
 * @Author: AllenSun
 * @Date: 2020/5/1 0:32
 */
@Component
@FeignClient(value = "INDEX-DATA-SERVICE8021",fallback = IndexDataClientFeignHystrix.class)
public interface IndexDataClient {

    @GetMapping("/data/{code}")
    public List<IndexData> getIndexData(@PathVariable("code") String code);
}
