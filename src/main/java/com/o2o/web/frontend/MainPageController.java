package com.o2o.web.frontend;

import com.o2o.entity.HeadLine;
import com.o2o.entity.ShopCategory;
import com.o2o.service.HeadLineService;
import com.o2o.service.ShopCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/11/17 15:23
 */
@Controller
@RequestMapping("/frontend")
public class MainPageController {
    private static Logger logger = LoggerFactory.getLogger(MainPageController.class);
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private HeadLineService headLineService;

    /**
     * 初始化前端展示系统的主页信息，包括获取一级店铺类别列表以及头条列表
     *
     * @return
     */
    @RequestMapping(value = "/listmainpageinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listMainPageInfo() {
        logger.debug("初始化前端展示系统的主页信息，获取一级店铺类别列表，以及头条列表start。。。");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        try {
            // 获取一级店铺类别列表(即parentId为空的ShopCategory)
            shopCategoryList = shopCategoryService.getShopCategoryList(null);
            logger.debug("获取的一级店铺类别列表信息为1"+shopCategoryList);
            modelMap.put("shopCategoryList", shopCategoryList);
        } catch (Exception e) {
            logger.debug("获取的一级店铺类别列表异常"+e.getMessage());
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        List<HeadLine> headLineList = new ArrayList<HeadLine>();
        try {
            // 获取状态为可用(1)的头条列表
            HeadLine headLineCondition = new HeadLine();
            headLineCondition.setEnableStatus(1);
            headLineList = headLineService.getHeadLineList(headLineCondition);
            logger.debug("获取状态为可用(1)的头条列表为"+headLineList);
            modelMap.put("headLineList", headLineList);
        } catch (Exception e) {
            logger.debug("获取状态为可用(1)的头条列表异常"+e.getMessage());
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        modelMap.put("success", true);
        return modelMap;
    }

}