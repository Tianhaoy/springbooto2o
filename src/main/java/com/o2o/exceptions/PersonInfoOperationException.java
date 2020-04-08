package com.o2o.exceptions;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 18:28
 */
public class PersonInfoOperationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1731072051960995926L;

    public PersonInfoOperationException(String msg) {
        super(msg);
    }
}
