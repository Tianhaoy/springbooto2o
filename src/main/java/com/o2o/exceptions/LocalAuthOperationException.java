package com.o2o.exceptions;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/11 23:21
 */
public class LocalAuthOperationException extends RuntimeException {

    private static final long serialVersionUID = -8260236137099919700L;

    public LocalAuthOperationException(String msg) {
        super(msg);
    }
}
