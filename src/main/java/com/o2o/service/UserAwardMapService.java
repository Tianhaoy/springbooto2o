package com.o2o.service;

import com.o2o.dto.UserAwardMapExecution;
import com.o2o.entity.UserAwardMap;
import com.o2o.exceptions.UserAwardMapOperationException;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 14:54
 */
public interface UserAwardMapService {

    /**
     * 根据传入的查询条件分页获取映射列表及总数
     *
     * @param userAwardCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    UserAwardMapExecution listUserAwardMap(UserAwardMap userAwardCondition, Integer pageIndex, Integer pageSize);


    /**
     * 根据传入的查询条件分页获取映射列表及总数
     *
     * @param userAwardCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    UserAwardMapExecution listReceivedUserAwardMap(UserAwardMap userAwardCondition, Integer pageIndex, Integer pageSize);

    /**
     * 根据传入的Id获取映射信息
     *
     * @param userAwardMapId
     * @return
     */
    UserAwardMap getUserAwardMapById(long userAwardMapId);

    /**
     * 领取奖品，添加映射信息
     *
     * @param userAwardMap
     * @return
     * @throws UserAwardMapOperationException
     */
    UserAwardMapExecution addUserAwardMap(UserAwardMap userAwardMap) throws UserAwardMapOperationException;

    /**
     * 修改映射信息，这里主要修改奖品领取状态
     *
     * @param userAwardMap
     * @return
     * @throws UserAwardMapOperationException
     */
    UserAwardMapExecution modifyUserAwardMap(UserAwardMap userAwardMap) throws UserAwardMapOperationException;
}
