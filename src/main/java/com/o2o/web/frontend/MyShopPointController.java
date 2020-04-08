package com.o2o.web.frontend;

import com.o2o.dto.UserShopMapExecution;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.UserShopMap;
import com.o2o.service.UserShopMapService;
import com.o2o.util.HttpServletRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 17:15
 */
@Controller
@RequestMapping("/frontend")
public class MyShopPointController {
    private static Logger logger = LoggerFactory.getLogger(MyShopPointController.class);
    @Autowired
    private UserShopMapService userShopMapService;

    /**
     * 列出用户的积分情况
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/listusershopmapsbycustomer", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listUserShopMapsByCustomer(HttpServletRequest request) {
        logger.debug("开始列出用户的积分情况---");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取分页信息
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        // 从session中获取顾客信息
        PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
        logger.debug("用户信息为"+user);
        // 空值判断
        if ((pageIndex > -1) && (pageSize > -1) && (user != null) && (user.getUserId() != null)) {
            UserShopMap userShopMapCondition = new UserShopMap();
            userShopMapCondition.setUser(user);
            long shopId = HttpServletRequestUtil.getLong(request, "shopId");
            logger.debug("店铺ID为"+shopId);
            if (shopId > -1) {
                // 若传入的店铺id不为空，则取出该店铺该顾客的积分情况
                Shop shop = new Shop();
                shop.setShopId(shopId);
                userShopMapCondition.setShop(shop);
            }
            String shopName = HttpServletRequestUtil.getString(request, "shopName");
            logger.debug("店铺名为"+shopName);
            if (shopName != null) {
                // 若商品名为非空，则将其添加进查询条件里进行模糊查询
                Shop shop = new Shop();
                shop.setShopName(shopName);
                userShopMapCondition.setShop(shop);
            }
            // 根据查询条件获取顾客的各店铺积分情况
            UserShopMapExecution ue = userShopMapService.listUserShopMap(userShopMapCondition, pageIndex, pageSize);
            logger.debug("顾客的各店铺积分情况"+ue.getUserShopMapList());
            modelMap.put("userShopMapList", ue.getUserShopMapList());
            modelMap.put("count", ue.getCount());
            modelMap.put("success", true);
        } else {
            logger.debug("缺少查询条件pageSize or pageIndex or shopId");
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }
        return modelMap;
    }
}
