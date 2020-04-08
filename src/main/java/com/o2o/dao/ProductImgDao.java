package com.o2o.dao;

import com.o2o.entity.ProductImg;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/11/10 17:16
 */
@Repository
public interface ProductImgDao {
    /**
     * 批量添加商品详情图片
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * 删除指定商品下的所有详情图
     *
     * @param productId
     * @return
     */
    int deleteProductImgByProductId(Long productId);

    /**
     * 列出某个商品的详情图列表
     *
     * @param productId
     * @return
     */
    List<ProductImg> queryProductImgList(Long productId);
}
