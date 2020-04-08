package com.o2o.enums;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 14:45
 */
public enum UserShopMapStateEnum {
    SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "操作失败"), NULL_USERSHOP_ID(-1002, "UserShopId为空"), NULL_USERSHOP_INFO(-1003,
            "传入了空的信息");

    private int state;

    private String stateInfo;

    private UserShopMapStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static UserShopMapStateEnum stateOf(int index) {
        for (UserShopMapStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
