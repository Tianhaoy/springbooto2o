package com.o2o.enums;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 18:04
 */
public enum AreaStateEnum {
    OFFLINE(-1, "非法区域"), SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(
            -1002, "区域信息为空");

    private int state;

    private String stateInfo;

    private AreaStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AreaStateEnum stateOf(int index) {
        for (AreaStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}

