package com.allen.springcloud.service;

import cn.hutool.core.collection.CollUtil;
import com.allen.springcloud.pojo.IndexData;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: IndexDataService
 * @Author: AllenSun
 * @Date: 2020/4/12 14:19
 */
@Service
@CacheConfig(cacheNames="index_datas")
public class IndexDataService {
    @Cacheable(key="'indexData-code-'+ #p0")
    public List<IndexData> get(String code){
        return CollUtil.toList();
    }
}
