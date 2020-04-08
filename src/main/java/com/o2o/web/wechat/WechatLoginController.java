package com.o2o.web.wechat;

import com.o2o.dto.UserAccessToken;
import com.o2o.dto.WechatAuthExecution;
import com.o2o.dto.WechatUser;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.WechatAuth;
import com.o2o.enums.WechatAuthStateEnum;
import com.o2o.service.PersonInfoService;
import com.o2o.service.WechatAuthService;
import com.o2o.util.wechat.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: TODO(获取关注公众号之后的微信用户信息的接口，如果在微信浏览器里访问)
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx99854bd30dd68292&redirect_uri=http://39.106.18.155/o2o/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx99854bd30dd68292&redirect_uri=http://o2o.babehome.com/o2o/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx99854bd30dd68292&redirect_uri=http://o2o.babehome.com/o2o/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=2#wechat_redirect
 * 则这里将会获取到code,之后再可以通过code获取到access_token 进而获取到用户信息
 * @Date 2019/11/30 19:51
 */
@Controller
@RequestMapping("wechatlogin")
public class WechatLoginController {

    private static Logger log = LoggerFactory.getLogger(WechatLoginController.class);
    private static final String FRONTEND = "1";
    private static final String SHOPEND = "2";
    @Autowired
    private PersonInfoService personInfoService;
    @Autowired
    private WechatAuthService wechatAuthService;

    @RequestMapping(value = "/logincheck", method = { RequestMethod.GET })
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        log.debug("开始微信登录get...");
        // 获取微信公众号传输过来的code,通过code可获取access_token,进而获取用户信息
        String code = request.getParameter("code");
        // 这个state可以用来传我们自定义的信息，方便程序调用，这里也可以不用
        String roleType = request.getParameter("state");
        log.debug("微信登录 code:" + code);
        log.debug("微信登录 state:" + roleType);
        WechatUser user = null;
        String openId = null;
        WechatAuth auth = null;
        if (null != code) {
            UserAccessToken token;
            try {
                // 通过code获取access_token
                token = WechatUtil.getUserAccessToken(code);
                log.debug("微信登录 token:" + token.toString());
                // 通过token获取accessToken
                String accessToken = token.getAccessToken();
                log.debug("微信登录 accessToken:" + accessToken);
                // 通过token获取openId
                openId = token.getOpenId();
                // 通过access_token和openId获取用户昵称等信息
                user = WechatUtil.getUserInfo(accessToken, openId);
                log.debug("微信登录 user:" + user.toString());
                request.getSession().setAttribute("openId", openId);
                auth = wechatAuthService.getWechatAuthByOpenId(openId);
                log.debug("通过微信账号信息查询结果为"+auth);
            } catch (IOException e) {
                log.error("getUserAccessToken or getUserInfo or findByOpenId 出现异常: " + e.getMessage());
            }
        }
        // 若微信帐号为空则需要注册微信帐号，同时注册用户信息
        if (auth == null) {
            log.debug("微信账号信息为空需要注册微信账号--");
            PersonInfo personInfo = WechatUtil.getPersonInfoFromRequest(user);
            auth = new WechatAuth();
            auth.setOpenId(openId);
            if (FRONTEND.equals(roleType)) {
                personInfo.setUserType(1);
            } else {
                personInfo.setUserType(2);
            }
            auth.setPersonInfo(personInfo);
            WechatAuthExecution we = wechatAuthService.register(auth);
            if (we.getState() != WechatAuthStateEnum.SUCCESS.getState()) {
                return null;
            } else {
                personInfo = personInfoService.getPersonInfoById(auth.getPersonInfo().getUserId());
                request.getSession().setAttribute("user", personInfo);
            }
        } else {
            request.getSession().setAttribute("user", auth.getPersonInfo());
        }
        // 若用户点击的是前端展示系统按钮则进入前端展示系统
        if (FRONTEND.equals(roleType)) {
            return "frontend/index";
        } else {
            return "shop/shoplist";
        }
    }
}

