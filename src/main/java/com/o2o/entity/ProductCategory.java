package com.o2o.entity;

import java.util.Date;

/**
 * @Description: TODO(商品类别实体类)
 * @Author ASUS
 * @Date 2019/10/23 21:17
 */
public class ProductCategory {
    private Long productCategoryId;
    //店铺id 是哪个店铺的类别
    private Long shopId;
    private String productCategoryName;
    //权重
    private Integer priority;
    private Date createTime;

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
