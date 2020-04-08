package com.o2o.dao;

import com.o2o.entity.WechatAuth;
import org.springframework.stereotype.Repository;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/1 19:03
 */
@Repository
public interface WechatAuthDao {

    /**
     * 通过openId查询对应本平台的微信帐号
     *
     * @param openId
     * @return
     */
    WechatAuth queryWechatInfoByOpenId(String openId);

    /**
     * 添加对应本平台的微信帐号
     *
     * @param wechatAuth
     * @return
     */
    int insertWechatAuth(WechatAuth wechatAuth);
}
