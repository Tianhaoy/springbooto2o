package com.o2o.service;

import com.o2o.dto.ShopAuthMapExecution;
import com.o2o.entity.ShopAuthMap;
import com.o2o.exceptions.ShopAuthMapOperationException;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/27 21:42
 */
public interface ShopAuthMapService {
    /**
     * 根据店铺Id分页显示该店铺的授权信息
     *
     * @param shopId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopAuthMapExecution listShopAuthMapByShopId(Long shopId, Integer pageIndex, Integer pageSize);

    /**
     * 根据shopAuthId返回对应的授权信息
     *
     * @param shopAuthId
     * @return
     */
    ShopAuthMap getShopAuthMapById(Long shopAuthId);

    /**
     * 添加授权信息
     *
     * @param shopAuthMap
     * @return
     * @throws ShopAuthMapOperationException
     */
    ShopAuthMapExecution addShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException;

    /**
     * 更新授权信息，包括职位，状态等
     *
     * @param shopAuthId
     * @param title
     * @param titleFlag
     * @param enableStatus
     * @return
     * @throws ShopAuthMapOperationException
     */
    ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException;

}
