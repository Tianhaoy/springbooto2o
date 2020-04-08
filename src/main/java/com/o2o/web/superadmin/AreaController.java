package com.o2o.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.AreaExecution;
import com.o2o.dto.ConstantForSuperAdmin;
import com.o2o.entity.Area;
import com.o2o.enums.AreaStateEnum;
import com.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/10/25 21:48
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    private static Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
        logger.debug("开始初始化头条列表信息---");
        long startTime = System.currentTimeMillis();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = new ArrayList<Area>();
        try {
            // 获取区域列表
            list = areaService.getAreaList();
            modelMap.put(ConstantForSuperAdmin.PAGE_SIZE, list);
            modelMap.put(ConstantForSuperAdmin.TOTAL, list.size());
        } catch (Exception e) {
            logger.debug(e.getMessage());
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}ms]", endTime - startTime);
        logger.info("===end===");
        return modelMap;
    }

    /**
     * 添加区域信息
     *
     * @param areaStr
     * @param request
     * @return
     */
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addArea(String areaStr, HttpServletRequest request) {
        logger.debug("开始添加区域信息---");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        Area area = null;
        try {
            // 接收前端传递过来的area json字符串信息并转换成Area实体类实例
            area = mapper.readValue(areaStr, Area.class);
            // decode可能有中文的地方
            area.setAreaName((area.getAreaName() == null) ? null : URLDecoder.decode(area.getAreaName(), "UTF-8"));
        } catch (Exception e) {
            logger.debug(e.getMessage());
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        // 空值判断
        if (area != null && area.getAreaName() != null) {
            try {
                // 添加区域信息
                AreaExecution ae = areaService.addArea(area);
                if (ae.getState() == AreaStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", ae.getStateInfo());
                }
            } catch (RuntimeException e) {
                logger.debug(e.getMessage());
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }

        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入区域信息");
        }
        return modelMap;
    }

    /**
     * 修改区域信息，主要修改名字
     *
     * @param areaStr
     * @param request
     * @return
     */
    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifyArea(String areaStr, HttpServletRequest request) {
        logger.debug("开始修改区域信息---");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        Area area = null;
        try {
            // 接收前端传递过来的area json字符串信息并转换成Area实体类实例
            area = mapper.readValue(areaStr, Area.class);
            area.setAreaName((area.getAreaName() == null) ? null : URLDecoder.decode(area.getAreaName(), "UTF-8"));
        } catch (Exception e) {
            logger.debug(e.getMessage());
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        // 空值判断
        if (area != null && area.getAreaId() != null) {
            try {
                // 修改区域信息
                AreaExecution ae = areaService.modifyArea(area);
                if (ae.getState() == AreaStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", ae.getStateInfo());
                }
            } catch (RuntimeException e) {
                logger.debug(e.getMessage());
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }

        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入区域信息");
        }
        return modelMap;
    }
}
