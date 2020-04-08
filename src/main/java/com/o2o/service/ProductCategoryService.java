package com.o2o.service;

import com.o2o.dto.ProductCategoryExecution;
import com.o2o.entity.ProductCategory;
import com.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/11/6 21:03
 */
public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     * @return
     */
    List<ProductCategory> getProductCategoryList(Long shopId);

    /**
     * 添加指定店铺下的商品类别
     * @param productCategoryList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;

    /**
     * 将次类别下的商品里的类别id置为空，在删除掉该商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategory(Long productCategoryId, Long shopId)
            throws ProductCategoryOperationException;
}
