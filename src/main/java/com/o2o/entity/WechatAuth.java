package com.o2o.entity;

import java.util.Date;

/**
 * @Description: TODO(微信账号实体类)
 * @Author ASUS
 * @Date 2019/10/23 20:42
 */
public class WechatAuth {
    //id
    private Long wechatAuthId;
    //openid 微信账号跟公众号绑定的唯一标识
    private String openId;
    private Date createTime;
    //跟PersonInfo实体类关联
    private PersonInfo personInfo;

    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
