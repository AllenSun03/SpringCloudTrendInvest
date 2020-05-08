package com.allen.springcloud.pojo;

/**
 * @ClassName: IndexData
 * @Author: AllenSun
 * @Date: 2020/4/12 12:43
 */
// @Data
// @AllArgsConstructor//全参构造方法
// @NoArgsConstructor//空参构造方法
public class IndexData {
    String date;
    float closePoint;

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public float getClosePoint() {
        return closePoint;
    }
    public void setClosePoint(float closePoint) {
        this.closePoint = closePoint;
    }
}
