package com.o2o.web.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/11/17 16:11
 */
@Controller
@RequestMapping("/frontend")
public class FrontendController {
    private static Logger logger = LoggerFactory.getLogger(FrontendController.class);
    /**
     * 首页路由
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index() {
        logger.debug("访问用户首页路由");
        return "frontend/index";
    }

    /**
     * 商品列表页路由
     * @return
     */
    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
    private String showShopList() {
        logger.debug("访问商品列表页路由");
        return "frontend/shoplist";
    }

    /**
     * 店铺详情页路由
     * @return
     */
    @RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
    private String showShopDetail() {
        logger.debug("访问店铺详情页路由");
        return "frontend/shopdetail";
    }

    /**
     * 商品详情页路由
     * @return
     */
    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
    private String showProductDetail() {
        logger.debug("访问商品详情页路由");
        return "frontend/productdetail";
    }

    /**
     * 店铺的奖品列表页路由
     *
     * @return
     */
    @RequestMapping(value = "/awardlist", method = RequestMethod.GET)
    private String showAwardList() {
        logger.debug("访问店铺的奖品列表页路由");
        return "frontend/awardlist";
    }

    /**
     * 奖品兑换列表页路由
     *
     * @return
     */
    @RequestMapping(value = "/pointrecord", method = RequestMethod.GET)
    private String showPointRecord() {
        logger.debug("访问奖品兑换列表页路由");
        return "frontend/pointrecord";
    }

    /**
     * 奖品详情页路由
     *
     * @return
     */
    @RequestMapping(value = "/myawarddetail", method = RequestMethod.GET)
    private String showMyAwardDetail() {
        logger.debug("访问奖品详情页路由");
        return "frontend/myawarddetail";
    }

    /**
     * 消费记录列表页路由
     *
     * @return
     */
    @RequestMapping(value = "/myrecord", method = RequestMethod.GET)
    private String showMyRecord() {
        logger.debug("访问消费记录列表页路由");
        return "frontend/myrecord";
    }

    /**
     * 用户各店铺积分信息页路由
     *
     * @return
     */
    @RequestMapping(value = "/mypoint", method = RequestMethod.GET)
    private String showMyPoint() {
        logger.debug("访问用户各店铺积分信息页路由");
        return "frontend/mypoint";
    }

    /**
     * 广告链接
     *
     * @return
     */
    @RequestMapping(value = "/advertone", method = RequestMethod.GET)
    private String advert() {
        logger.debug("访问广告链接路由");
        return "frontend/404";
    }
}
