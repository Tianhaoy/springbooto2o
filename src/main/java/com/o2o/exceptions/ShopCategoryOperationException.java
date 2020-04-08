package com.o2o.exceptions;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/11 22:53
 */
public class ShopCategoryOperationException extends RuntimeException {

    private static final long serialVersionUID = 5423986306645291467L;

    public ShopCategoryOperationException(String msg) {
        super(msg);
    }
}
