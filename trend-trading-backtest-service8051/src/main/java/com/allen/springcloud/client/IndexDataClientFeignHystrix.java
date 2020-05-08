package com.allen.springcloud.client;

import cn.hutool.core.collection.CollectionUtil;
import com.allen.springcloud.pojo.IndexData;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: IndexDataClientFeignHystrix
 * @Author: AllenSun
 * @Date: 2020/5/1 0:35
 */
@Component
public class IndexDataClientFeignHystrix implements IndexDataClient {

    @Override
    public List<IndexData> getIndexData(String code) {
        IndexData indexData = new IndexData();
        indexData.setClosePoint(0);
        indexData.setDate("0000-00-00");
        return CollectionUtil.toList(indexData);
    }
}
