package com.allen.springcloud.controller;

import com.allen.springcloud.pojo.IndexData;
import com.allen.springcloud.service.IndexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: IndexDataController
 * @Author: AllenSun
 * @Date: 2020/4/12 12:47
 */
@RestController
public class IndexDataController {
    @Autowired
    IndexDataService indexDataService;

    @GetMapping("/freshIndexData/{code}")
    public String fresh(@PathVariable("code") String code) throws Exception {
        indexDataService.fresh(code);
        return "fresh index data successfully";
    }

    @GetMapping("/getIndexData/{code}")
    public List<IndexData> get(@PathVariable("code") String code) throws Exception {
        return indexDataService.get(code);
    }

    @GetMapping("/removeIndexData/{code}")
    public String remove(@PathVariable("code") String code) throws Exception {
        indexDataService.remove(code);
        return "remove index data successfully";
    }
}