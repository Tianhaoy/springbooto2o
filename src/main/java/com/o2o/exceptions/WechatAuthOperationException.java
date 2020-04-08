package com.o2o.exceptions;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/1 19:30
 */
public class WechatAuthOperationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -4290016045533442745L;

    public WechatAuthOperationException(String msg) {
        super(msg);
    }
}
