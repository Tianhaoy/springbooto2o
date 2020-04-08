package com.o2o.service;

import com.o2o.dto.UserShopMapExecution;
import com.o2o.entity.UserShopMap;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 14:41
 */
public interface UserShopMapService {

    /**
     * 根据传入的查询信息分页查询用户积分列表
     *
     * @param userShopMapCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    UserShopMapExecution listUserShopMap(UserShopMap userShopMapCondition, int pageIndex, int pageSize);

    /**
     * 根据用户Id和店铺Id返回该用户在某个店铺的积分情况
     *
     * @param userId
     * @param shopId
     * @return
     */
    UserShopMap getUserShopMap(long userId, long shopId);

}

