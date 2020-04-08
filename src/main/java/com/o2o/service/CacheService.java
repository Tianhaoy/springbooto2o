package com.o2o.service;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/11 22:59
 */
public interface CacheService {
    /**
     * 依据key前缀删除匹配该模式下的所有key-value 如传入:shopcategory,则shopcategory_allfirstlevel等
     * 以shopcategory打头的key_value都会被清空
     *
     * @param keyPrefix
     * @return
     */
    void removeFromCache(String keyPrefix);

}

