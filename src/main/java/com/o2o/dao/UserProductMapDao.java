package com.o2o.dao;

import com.o2o.entity.UserProductMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/26 0:06
 */
@Repository
public interface UserProductMapDao {
    /**
     * 根据查询条件分页返回用户购买商品的记录列表
     *
     * @param userProductCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<UserProductMap> queryUserProductMapList(@Param("userProductCondition") UserProductMap userProductCondition,
                                                 @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /**
     * 配合queryUserProductMapList根据相同的查询条件返回用户购买商品的记录总数
     *
     * @param userProductCondition
     * @return
     */
    int queryUserProductMapCount(@Param("userProductCondition") UserProductMap userProductCondition);

    /**
     * 添加一条用户购买商品的记录
     *
     * @param userProductMap
     * @return
     */
    int insertUserProductMap(UserProductMap userProductMap);
}
