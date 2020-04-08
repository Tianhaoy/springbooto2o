package com.o2o.service;

import com.o2o.dto.WechatAuthExecution;
import com.o2o.entity.WechatAuth;
import com.o2o.exceptions.WechatAuthOperationException;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/1 19:29
 */
public interface WechatAuthService {

    /**
     * 通过openId查找平台对应的微信帐号
     *
     * @param openId
     * @return
     */
    WechatAuth getWechatAuthByOpenId(String openId);

    /**
     * 注册本平台的微信帐号
     *
     * @param wechatAuth
     * @return
     * @throws RuntimeException
     */
    WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;
}
