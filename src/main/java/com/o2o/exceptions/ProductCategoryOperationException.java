package com.o2o.exceptions;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/11/7 21:53
 */
public class ProductCategoryOperationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1182563719599527969L;

    public ProductCategoryOperationException(String msg) {
        super(msg);
    }
}

