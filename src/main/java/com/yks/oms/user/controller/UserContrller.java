package com.yks.oms.user.controller;

import com.yks.oms.user.constant.StateCode;
import com.yks.oms.user.constant.StateInfo;
import com.yks.oms.user.entity.User;
import com.yks.oms.user.service.UserService;
import com.yks.oms.user.utils.LoginUtil;
import com.yks.oms.user.vo.LoginVO;
import com.yks.oms.user.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  @author zhouhuan 
 *  @version 1.0
 *  @see  
 *  @since JDK1.8
 *  @date 2018年1月30日
 */
@Controller
public class UserContrller {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserContrller.class);


    /**
     * 用户登录
     *
     * @param user 用户登录信息
     * @return
     */
    @RequestMapping(value = "api/oms/user/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginVO login(@RequestBody User user, HttpSession session, HttpServletResponse response) {
        LoginVO loginVO = new LoginVO();
        //判断用户信息是否完整
        Boolean result = LoginUtil.isMatch(user);
        if(result){
            //登录sso
            loginVO = userService.login(user);
            //登录成功就将用于信息存入session中
            if (StateCode.SUCCES.equals(loginVO.getState())) {
                user.setTicket(loginVO.getTicket());
                session.setAttribute("user", user);
            }
            //用于ajax post跨域（*，最好指定确定的http等协议+ip+端口号）
            response.addHeader("Access-Control-Allow-Origin", "*");
        }else{
            loginVO.setState(StateCode.FAIL_402);
            loginVO.setMsg(StateInfo.STATE_402.INFO);
        }
        return loginVO;
    }

    /**
     * 用户退出
     *
     * @return
     */
    @RequestMapping(value = "api/oms/user/logout", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo logout(HttpSession session) {
        ResultVo resultVo = new ResultVo();
        try {
            //销毁session
            session.invalidate();
            resultVo.setState(StateCode.SUCCES);
            resultVo.setMsg(StateInfo.STATE_200.INFO);
        } catch (Exception e) {
            logger.error("用户退出失败", e.getMessage());
            resultVo.setState(StateCode.FAIL_500);
            resultVo.setMsg(StateInfo.STATE_500.INFO);
        }
        return resultVo;
    }
}
