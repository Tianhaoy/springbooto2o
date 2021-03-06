package com.o2o.service;

import com.o2o.dto.ImageHolder;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/10/26 18:12
 */
public interface ShopService {
    /**
     * 根据shopCondition分页返回相应店铺列表
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
    /**
     * 通过店铺Id获取店铺信息
     *
     * @param shopId
     * @return
     */
    Shop getByShopId(Long shopId);
    /**
     * 更新店铺信息，包括对图片的处理
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
    /**
     * 注册店铺信息，包括图片处理
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
