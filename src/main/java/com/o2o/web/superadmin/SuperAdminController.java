package com.o2o.web.superadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 18:02
 */
@Controller
@RequestMapping(value = "/superadmin", method = { RequestMethod.GET, RequestMethod.POST })
public class SuperAdminController {
    private static Logger logger = LoggerFactory.getLogger(SuperAdminController.class);

    @RequestMapping(value = "/areamanage", method = RequestMethod.GET)
    private String areamanagement() {
        // 区域管理页
        logger.debug("访问区域管理页路由");
        return "superadmin/areamanage";
    }

    @RequestMapping(value = "/headlinemanage", method = RequestMethod.GET)
    private String headLinemanagement() {
        // 头条管理页
        logger.debug("访问头条管理页路由");
        return "superadmin/headlinemanage";
    }

    @RequestMapping(value = "/shopcategorymanage", method = RequestMethod.GET)
    private String shopCategorymanage() {
        // 店铺类别管理页
        logger.debug("访问店铺类别管理页路由");
        return "superadmin/shopcategorymanage";
    }

    @RequestMapping(value = "/shopmanage", method = RequestMethod.GET)
    private String shopmanage() {
        // 店铺管理页
        logger.debug("访问店铺管理页路由");
        return "superadmin/shopmanage";
    }

    @RequestMapping(value = "/personinfomanage", method = RequestMethod.GET)
    private String personInfomanage() {
        // 用户信息管理页
        logger.debug("访问用户信息管理页路由");
        return "superadmin/personinfomanage";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    private String main() {
        // 超级管理员主页
        logger.debug("访问超级管理员主页路由");
        return "superadmin/main";
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    private String top() {
        // 超级管理员frame top部分
        logger.debug("访问超级管理员frame top部分路由");
        return "superadmin/top";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String login() {
        // 超级管理员登录页
        logger.debug("访问超级管理员登录页路由");
        return "superadmin/login";
    }

}
