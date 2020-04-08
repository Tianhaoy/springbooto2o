package com.o2o.web.cache;

import com.o2o.service.AreaService;
import com.o2o.service.CacheService;
import com.o2o.service.HeadLineService;
import com.o2o.service.ShopCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 17:44
 */
@Controller
public class CacheController {
    private static Logger logger = LoggerFactory.getLogger(CacheController.class);
    @Autowired
    private CacheService cacheService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private HeadLineService headLineService;
    @Autowired
    private ShopCategoryService shopCategoryService;

    /**
     * 清除区域信息相关的所有redis缓存
     *
     * @return
     */
    @RequestMapping(value = "/clearcache4area", method = RequestMethod.GET)
    private String clearCache4Area() {
        logger.debug("开始clean区域信息相关redis缓存");
        cacheService.removeFromCache(areaService.AREALISTKEY);
        logger.debug("结束clean区域信息相关redis缓存");
        return "shop/operationsuccess";
    }

    /**
     * 清除头条相关的所有redis缓存
     *
     * @return
     */
    @RequestMapping(value = "/clearcache4headline", method = RequestMethod.GET)
    private String clearCache4Headline() {
        logger.debug("开始clean头条信息相关redis缓存");
        cacheService.removeFromCache(headLineService.HLLISTKEY);
        logger.debug("结束clean头条信息相关redis缓存");
        return "shop/operationsuccess";
    }

    /**
     * 清除店铺类别相关的所有redis缓存
     *
     * @return
     */
    @RequestMapping(value = "/clearcache4shopcategory", method = RequestMethod.GET)
    private String clearCache4ShopCategory() {
        logger.debug("开始clean店铺类别信息相关redis缓存");
        cacheService.removeFromCache(shopCategoryService.SCLISTKEY);
        logger.debug("结束clean店铺类别信息相关redis缓存");
        return "shop/operationsuccess";
    }

}
