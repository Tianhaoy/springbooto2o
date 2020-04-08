package com.o2o.exceptions;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/11 22:22
 */
public class AreaOperationException extends RuntimeException {

    private static final long serialVersionUID = -1512771573934050550L;

    public AreaOperationException(String msg) {
        super(msg);
    }
}
