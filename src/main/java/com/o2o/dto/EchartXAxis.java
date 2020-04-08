package com.o2o.dto;

import java.util.HashSet;

/**
 * @Description: TODO(迎合echart里的xAxis项)
 * @Author ASUS
 * @Date 2019/12/28 17:37
 */
public class EchartXAxis {
    private String type = "category";
    //为了去重
    private HashSet<String> data;

    public HashSet<String> getData() {
        return data;
    }

    public void setData(HashSet<String> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

}
