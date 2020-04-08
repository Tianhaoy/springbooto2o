package com.o2o.web.frontend;

import com.o2o.dto.UserProductMapExecution;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Product;
import com.o2o.entity.Shop;
import com.o2o.entity.UserProductMap;
import com.o2o.service.UserProductMapService;
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
 * @Date 2019/12/29 17:00
 */
@Controller
@RequestMapping("/frontend")
public class MyProductController {
    private static Logger logger = LoggerFactory.getLogger(MyProductController.class);
    @Autowired
    private UserProductMapService userProductMapService;

    /**
     * 列出某个顾客的商品消费信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/listuserproductmapsbycustomer", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listUserProductMapsByCustomer(HttpServletRequest request) {
        logger.debug("开始列出某个顾客的商品消费信息---");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取分页信息
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        // 从session里获取顾客信息
        PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
        logger.debug("用户信息为"+user);
        // 空值判断
        if ((pageIndex > -1) && (pageSize > -1) && (user != null) && (user.getUserId() != -1)) {
            UserProductMap userProductMapCondition = new UserProductMap();
            userProductMapCondition.setUser(user);
            long shopId = HttpServletRequestUtil.getLong(request, "shopId");
            logger.debug("店铺ID为"+shopId);
            if (shopId > -1) {
                // 若传入店铺信息，则列出某个店铺下该顾客的消费历史
                Shop shop = new Shop();
                shop.setShopId(shopId);
                userProductMapCondition.setShop(shop);
            }
            String productName = HttpServletRequestUtil.getString(request, "productName");
            logger.debug("商品名"+productName);
            if (productName != null) {
                // 若传入的商品名不为空，则按照商品名模糊查询
                Product product = new Product();
                product.setProductName(productName);
                userProductMapCondition.setProduct(product);
            }
            // 根据查询条件分页返回用户消费信息
            UserProductMapExecution ue = userProductMapService.listUserProductMap(userProductMapCondition, pageIndex,
                    pageSize);
            logger.debug("用户消费信息"+ue.getUserProductMapList());
            modelMap.put("userProductMapList", ue.getUserProductMapList());
            modelMap.put("count", ue.getCount());
            modelMap.put("success", true);
        } else {
            logger.debug("缺少查询条件 pageSize or pageIndex or shopId");
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }
        return modelMap;
    }
}

