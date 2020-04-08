package com.o2o.web.frontend;

import com.o2o.dto.AwardExecution;
import com.o2o.entity.Award;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.UserShopMap;
import com.o2o.service.AwardService;
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
 * @Date 2019/12/29 15:55
 */
@Controller
@RequestMapping("/frontend")
public class ShopAwardController {
    private static Logger logger = LoggerFactory.getLogger(ShopAwardController.class);
    @Autowired
    private AwardService awardService;
    @Autowired
    private UserShopMapService userShopMapService;

    /**
     * 列出店铺设定的奖品列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/listawardsbyshop", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listAwardsByShop(HttpServletRequest request) {
        logger.debug("开始列出店铺设定的奖品列表---");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取分页信息
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        // 获取店铺Id
        long shopId = HttpServletRequestUtil.getLong(request, "shopId");
        logger.debug("店铺ID为"+shopId);
        // 空值判断
        if ((pageIndex > -1) && (pageSize > -1) && (shopId > -1)) {
            // 获取前端可能输入的奖品名模糊查询
            String awardName = HttpServletRequestUtil.getString(request, "awardName");
            Award awardCondition = compactAwardCondition4Search(shopId, awardName);
            // 传入查询条件分页获取奖品信息
            AwardExecution ae = awardService.getAwardList(awardCondition, pageIndex, pageSize);
            modelMap.put("awardList", ae.getAwardList());
            modelMap.put("count", ae.getCount());
            modelMap.put("success", true);
            // 从Session中获取用户信息，主要是为了显示该用户在本店铺的积分
            PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
            // 空值判断
            if (user != null && user.getUserId() != null) {
                // 获取该用户在本店铺的积分信息
                UserShopMap userShopMap = userShopMapService.getUserShopMap(user.getUserId(), shopId);
                if (userShopMap == null) {
                    modelMap.put("totalPoint", 0);
                } else {
                    modelMap.put("totalPoint", userShopMap.getPoint());
                }
            }
        } else {
            logger.debug("缺少查询条件pageSize or pageIndex or shopId");
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }

        return modelMap;
    }

    /**
     * 封装查询条件
     *
     * @param shopId
     * @param awardName
     * @return
     */
    private Award compactAwardCondition4Search(long shopId, String awardName) {
        Award awardCondition = new Award();
        awardCondition.setShopId(shopId);
        // 只取出可用的奖品
        awardCondition.setEnableStatus(1);
        if (awardName != null) {
            awardCondition.setAwardName(awardName);
        }
        return awardCondition;
    }
}
