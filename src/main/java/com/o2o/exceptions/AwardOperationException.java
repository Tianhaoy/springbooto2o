package com.o2o.exceptions;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 15:18
 */
public class AwardOperationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -6160145499284104244L;

    public AwardOperationException(String msg) {
        super(msg);
    }
}
