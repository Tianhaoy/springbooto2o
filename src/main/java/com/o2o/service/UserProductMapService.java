package com.o2o.service;

import com.o2o.dto.UserProductMapExecution;
import com.o2o.entity.UserProductMap;
import com.o2o.exceptions.UserProductMapOperationException;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/28 16:48
 */
public interface UserProductMapService {
    /**
     * 通过传入的查询条件分页列出用户消费信息列表
     *
     * @param shopId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    UserProductMapExecution listUserProductMap(UserProductMap userProductCondition, Integer pageIndex,
                                               Integer pageSize);

    /**
     *
     * @param userProductMap
     * @return
     * @throws UserProductMapOperationException
     */
    UserProductMapExecution addUserProductMap(UserProductMap userProductMap) throws UserProductMapOperationException;
}
