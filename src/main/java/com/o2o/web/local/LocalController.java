package com.o2o.web.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author ASUS
 * @Date 2019/12/13 23:15
 */
@Controller
@RequestMapping("/local")
public class LocalController {
    private static Logger logger = LoggerFactory.getLogger(LocalController.class);

    /**
     * 绑定帐号页路由
     *
     * @return
     */
    @RequestMapping(value = "/accountbind", method = RequestMethod.GET)
    private String accountbind() {
        logger.debug("访问绑定帐号页路由");
        return "local/accountbind";
    }
    /**
     * 修改密码页路由
     *
     * @return
     */
    @RequestMapping(value = "/changepsw", method = RequestMethod.GET)
    private String changepsw() {
        logger.debug("访问修改密码页路由");
        return "local/changepsw";
    }
    /**
     * 登录页路由
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String login() {
        logger.debug("访问登录页路由");
        return "local/login";
    }
}
