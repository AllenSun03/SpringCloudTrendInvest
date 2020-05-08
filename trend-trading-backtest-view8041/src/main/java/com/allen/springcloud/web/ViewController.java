package com.allen.springcloud.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: ViewController
 * @Author: AllenSun
 * @Date: 2020/5/1 1:07
 */
@Controller
@RefreshScope//表示允许刷新
public class ViewController {

    @Value("${config.info}")
    String version;

    @GetMapping("/")
    public String view(Model m) throws Exception {
        m.addAttribute("version", version);
        return "view";
    }
}
