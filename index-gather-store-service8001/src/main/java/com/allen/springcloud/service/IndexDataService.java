package com.allen.springcloud.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import com.allen.springcloud.pojo.IndexData;
import com.allen.springcloud.util.SpringContextUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: IndexDataService
 * @Author: AllenSun
 * @Date: 2020/4/12 12:46
 */
@Service
@CacheConfig(cacheNames="index_datas")
public class IndexDataService {

    private Map<String, List<IndexData>> indexDatas=new HashMap<>();
    @Autowired RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "third_part_not_connected")
    public List<IndexData> fresh(String code) {
        //从第三方根据code获取数据
        List<IndexData> indexeDatas =fetch_indexes_from_third_part(code);

        //把code和data放进Map里（没有问题，能取到值）
        indexDatas.put(code, indexeDatas);

        //输出code值
        System.out.println("code:"+code);
        //输出data长度
        System.out.println("indexeDatas:"+indexDatas.get(code).size());

        IndexDataService indexDataService = SpringContextUtil.getBean(IndexDataService.class);
        //从redis中移除code对应的data
        indexDataService.remove(code);
        // System.out.println("11111111111111111111111");
        //从Map里取出值，并且存放到redis中（报异常了）
        return indexDataService.store(code);
    }

    //负责从redis中删除数据
    @CacheEvict(key="'indexData-code-'+ #p0")
    public void remove(String code){

    }

    //从Map中获取值，并且存放到redis中（把get取到的data值，根据code值放到redis的对应位置）
    @CachePut(key="'indexData-code-'+ #p0")
    public List<IndexData> store(String code){
        //这一步也是能获取到值的，为什么就是放不到redis中
        // List<IndexData> list=new ArrayList<>();
        // IndexData indexData=new IndexData();
        // indexData.setDate("1996-06-18");
        // indexData.setClosePoint(11111f);
        // list.add(indexData);
        // return list;
        List<IndexData> list=indexDatas.get(code);
        return list;
        // return indexDatas.get(code);
    }

    //只负责从redis或者别的地方取数据
    @Cacheable(key="'indexData-code-'+ #p0")
    public List<IndexData> get(String code){
        return CollUtil.toList();
    }

    //负责从第三方获取数据
    public List<IndexData> fetch_indexes_from_third_part(String code){
        List<Map> temp= restTemplate.getForObject("http://127.0.0.1:8090/indexes/"+code+".json",List.class);
        return map2IndexData(temp);
    }

    private List<IndexData> map2IndexData(List<Map> temp) {
        List<IndexData> indexDatas = new ArrayList<>();
        for (Map map : temp) {
            String date = map.get("date").toString();
            float closePoint = Convert.toFloat(map.get("closePoint"));
            IndexData indexData = new IndexData();

            indexData.setDate(date);
            indexData.setClosePoint(closePoint);
            indexDatas.add(indexData);
        }

        return indexDatas;
    }

    public List<IndexData> third_part_not_connected(String code){
        System.out.println("third_part_not_connected()");
        IndexData index= new IndexData();
        index.setClosePoint(0);
        index.setDate("n/a");
        return CollectionUtil.toList(index);
    }
}
