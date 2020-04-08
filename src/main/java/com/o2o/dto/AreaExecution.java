package com.o2o.dto;

import com.o2o.entity.Area;
import com.o2o.enums.AreaStateEnum;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 18:03
 */
public class AreaExecution {
    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    // 店铺数量
    private int count;

    // 操作的award（增删改商品的时候用）
    private Area area;

    // 获取的award列表(查询商品列表的时候用)
    private List<Area> areaList;

    public AreaExecution() {
    }

    // 失败的构造器
    public AreaExecution(AreaStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 成功的构造器
    public AreaExecution(AreaStateEnum stateEnum, Area area) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.area = area;
    }

    // 成功的构造器
    public AreaExecution(AreaStateEnum stateEnum, List<Area> areaList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.areaList = areaList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

}
