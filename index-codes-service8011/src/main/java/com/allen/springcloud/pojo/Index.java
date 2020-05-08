package com.allen.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Index
 * @Author: AllenSun
 * @Date: 2020/4/12 1:45
 */
@Data
@AllArgsConstructor//全参构造方法
@NoArgsConstructor//空参构造方法
public class Index {
    private String code;
    private String name;
}
