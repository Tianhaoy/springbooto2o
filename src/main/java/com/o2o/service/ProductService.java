package com.o2o.service;

import com.o2o.dto.ImageHolder;
import com.o2o.dto.ProductExecution;
import com.o2o.entity.Product;
import com.o2o.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/11/10 17:34
 */
public interface ProductService {
    /**
     * 查询商品列别并分页，可输入的条件有：商品名（模糊），商品状态，店铺Id，商品类别
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
    /**
     * 添加商品信息以及图片处理
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)throws ProductOperationException;

    /**
     * 通过商品Id查询唯一的商品信息
     * @param productId
     * @return
     */
    Product getProductById(Long productId);

    /**
     * 修改商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)throws ProductOperationException;

}