package com.o2o.service;

import com.o2o.entity.ProductSellDaily;

import java.util.Date;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/28 16:35
 */
public interface ProductSellDailyService {
    /**
     * 每日定时对所有店铺的商品销量进行统计
     */
    void dailyCalculate();

    /**
     * 根据查询条件返回商品日销售的统计列表
     *
     * @param productSellDailyCondition
     * @param beginTime
     * @param endTime
     * @return
     */
    List<ProductSellDaily> listProductSellDaily(ProductSellDaily productSellDailyCondition, Date beginTime,
                                                Date endTime);
}

