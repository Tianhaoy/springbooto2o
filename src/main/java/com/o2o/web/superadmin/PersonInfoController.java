package com.o2o.web.superadmin;

import com.o2o.dto.ConstantForSuperAdmin;
import com.o2o.dto.PersonInfoExecution;
import com.o2o.entity.PersonInfo;
import com.o2o.enums.PersonInfoStateEnum;
import com.o2o.service.PersonInfoService;
import com.o2o.util.HttpServletRequestUtil;
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
import java.util.Map;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/29 18:01
 */
@Controller
@RequestMapping("/superadmin")
public class PersonInfoController {
    private static Logger logger = LoggerFactory.getLogger(PersonInfoController.class);
    @Autowired
    private PersonInfoService personInfoService;

    /**
     * 列出用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/listpersonInfos", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> listPersonInfos(HttpServletRequest request) {
        logger.debug("开始列出用户信息---");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        PersonInfoExecution pie = null;
        // 获取分页信息
        int pageIndex = HttpServletRequestUtil.getInt(request, ConstantForSuperAdmin.PAGE_NO);
        int pageSize = HttpServletRequestUtil.getInt(request, ConstantForSuperAdmin.PAGE_SIZE);
        if (pageIndex > 0 && pageSize > 0) {
            try {
                PersonInfo personInfo = new PersonInfo();
                int enableStatus = HttpServletRequestUtil.getInt(request, "enableStatus");
                if (enableStatus > -1) {
                    // 若查询条件中有按照可用状态来查询，则将其作为查询条件传入
                    personInfo.setEnableStatus(enableStatus);
                }
                String name = HttpServletRequestUtil.getString(request, "name");
                if (name != null) {
                    // 若查询条件中有按照名字来查询，则将其作为查询条件传入，并decode
                    personInfo.setName(URLDecoder.decode(name, "UTF-8"));
                }
                pie = personInfoService.getPersonInfoList(personInfo, pageIndex, pageSize);
            } catch (Exception e) {
                logger.debug(e.getMessage());
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
            if (pie.getPersonInfoList() != null) {
                modelMap.put(ConstantForSuperAdmin.PAGE_SIZE, pie.getPersonInfoList());
                modelMap.put(ConstantForSuperAdmin.TOTAL, pie.getCount());
                modelMap.put("success", true);
            } else {
                modelMap.put(ConstantForSuperAdmin.PAGE_SIZE, new ArrayList<PersonInfo>());
                modelMap.put(ConstantForSuperAdmin.TOTAL, 0);
                modelMap.put("success", true);
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "空的查询信息");
            return modelMap;
        }
    }

    /**
     * 修改用户信息，主要是修改用户帐号可用状态
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/modifypersonInfo", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifyPersonInfo(HttpServletRequest request) {
        logger.debug("开始修改用户信息---");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 从前端请求中获取用户Id以及可用状态
        long userId = HttpServletRequestUtil.getLong(request, "userId");
        int enableStatus = HttpServletRequestUtil.getInt(request, "enableStatus");
        // 非空判断
        if (userId >= 0 && enableStatus >= 0) {
            try {
                PersonInfo pi = new PersonInfo();
                pi.setUserId(userId);
                pi.setEnableStatus(enableStatus);
                // 修改用户可用状态
                PersonInfoExecution ae = personInfoService.modifyPersonInfo(pi);
                if (ae.getState() == PersonInfoStateEnum.SUCCESS.getState()) {
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
            modelMap.put("errMsg", "请输入需要修改的帐号信息");
        }
        return modelMap;
    }

}
