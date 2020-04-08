package com.o2o.web.shopadmin;

import com.o2o.web.frontend.FrontendController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/10/30 22:47
 */
@Controller
@RequestMapping(value = "shopadmin",method ={RequestMethod.GET})
/**
 * 主要用来解析路由并转发到相应的html中
 *
 * @author xiangze
 *
 */
public class ShopAdminController {
    private static Logger logger = LoggerFactory.getLogger(ShopAdminController.class);

    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        // 转发至店铺注册/编辑页面
        logger.debug("访问店铺注册/编辑页面路由");
        return "shop/shopoperation";
    }
    @RequestMapping(value = "/shoplist")
    public String shopList(){
        // 转发至店铺列表页面
        logger.debug("访问店铺列表页面路由");
        return "shop/shoplist";
    }
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement(){
        // 转发至店铺管理页面
        logger.debug("访问店铺管理页面路由");
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanagement")
    public String shopProductCategoryManagement(){
        // 转发至商品类别管理页面
        logger.debug("访问商品类别管理页面路由");
        return "shop/productcategorymanagement";
    }

    @RequestMapping(value = "/productoperation")
    public String productOperation(){
        //转发至商品添加/编辑页面
        logger.debug("访问商品添加/编辑页面路由");
        return "shop/productoperation";
    }

    @RequestMapping(value = "/productmanagement")
    public String productManagement(){
        //转发至商品管理页面
        logger.debug("访问商品管理页面路由");
        return "shop/productmanagement";
    }

    @RequestMapping(value = "/shopauthmanagement")
    public String shopAuthManagement() {
        // 转发至店铺授权页面
        logger.debug("访问店铺授权页面路由");
        return "shop/shopauthmanagement";
    }

    @RequestMapping(value = "/shopauthedit")
    public String shopAuthEdit() {
        // 转发至授权信息修改页面
        logger.debug("访问授权信息修改页面路由");
        return "shop/shopauthedit";
    }

    @RequestMapping(value = "/operationsuccess", method = RequestMethod.GET)
    private String operationSuccess() {
        // 转发至操作失败的页面
        logger.debug("访问操作失败的页面路由");
        return "shop/operationsuccess";
    }

    @RequestMapping(value = "/operationfail", method = RequestMethod.GET)
    private String operationFail() {
        // 转发至操作成功的页面
        logger.debug("访问操作成功的页面路由");
        return "shop/operationfail";
    }

    @RequestMapping(value = "/productbuycheck", method = RequestMethod.GET)
    private String productBuyCheck() {
        // 转发至店铺的消费记录的页面
        logger.debug("访问店铺的消费记录的页面路由");
        return "shop/productbuycheck";
    }

    @RequestMapping(value = "/awardmanagement", method = RequestMethod.GET)
    private String awardManagement() {
        // 奖品管理页路由
        logger.debug("访问奖品管理页路由");
        return "shop/awardmanagement";
    }

    @RequestMapping(value = "/awardoperation", method = RequestMethod.GET)
    private String awardEdit() {
        // 奖品编辑页路由
        logger.debug("访问奖品编辑页路由");
        return "shop/awardoperation";
    }

    @RequestMapping(value = "/usershopcheck", method = RequestMethod.GET)
    private String userShopCheck() {
        // 店铺用户积分统计路由
        logger.debug("访问店铺用户积分统计路由");
        return "shop/usershopcheck";
    }

    @RequestMapping(value = "/awarddelivercheck", method = RequestMethod.GET)
    private String awardDeliverCheck() {
        // 店铺用户积分兑换路由
        logger.debug("访问店铺用户积分兑换路由");
        return "shop/awarddelivercheck";
    }
}
