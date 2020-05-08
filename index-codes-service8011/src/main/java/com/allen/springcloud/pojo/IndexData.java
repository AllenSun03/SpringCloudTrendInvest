package com.allen.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: IndexData
 * @Author: AllenSun
 * @Date: 2020/4/12 12:43
 */
@Data
@AllArgsConstructor//全参构造方法
@NoArgsConstructor//空参构造方法
public class IndexData {
    private String date;
    private float closePoint;
}
