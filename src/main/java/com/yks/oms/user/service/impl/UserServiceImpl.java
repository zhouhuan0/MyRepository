package com.yks.oms.user.service.impl;

import com.yks.oms.user.constant.SSOInfo;
import com.yks.oms.user.constant.StateCode;
import com.yks.oms.user.constant.StateInfo;
import com.yks.oms.user.entity.User;
import com.yks.oms.user.service.UserService;
import com.yks.oms.user.utils.*;
import com.yks.oms.user.vo.LogVO;
import com.yks.oms.user.vo.LoginVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *  @author zhouhuan 
 *  @version 1.0 
 *  @see  
 *  @since JDK1.8
 *  @date 2018年1月30日
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 从sso系统获取ticket
     *
     * @return ticket
     */
    public String getTicketFromSSO() {
        //发送get请求向sso获取票据
        String result = HttpClientUtil.doGet(SSOInfo.SSO_TICKET_URL);
        //解析结果获取票据
        String ticket = TicketUtils.parseJsonStr(result);
        return ticket;
    }

    /**
     * 登录sso系统
     *
     * @param userInfo 用户信息
     * @return
     */
    private LoginVO getInfoFromSSO(User userInfo) {
        //拼接用户登录sso的url
        String url = UrlUtil.getUrl(userInfo);
        //发送get请求
        String result = HttpClientUtil.doGet(url);
        //解析结果获取返回前端信息
        LoginVO loginVO = LoginUtil.parseJsonStr(result);
        // 打印日志
        LogVO logVO = new LogVO();
        logVO.setParam("{\"username\":" + userInfo.getUserName() + ",password:\"****\",\"ticket\":" + userInfo.getTicket() + "}");
        logVO.setMessage("SSO 返回的数据:" + result);
        logger.info(logVO.toString());
        return loginVO;
    }

    /**
     * 用户登录
     *
     * @param user 用户登录信息
     * @return
     */
    @Override
    public LoginVO login(User user) {
        //获取票据
        String ticket = getTicketFromSSO();
        LoginVO loginVO = new LoginVO();
        //票据不为空就登录sso
        if (StringUtils.isNotBlank(ticket)) {
            user.setTicket(ticket);
            //登入sso系统
            loginVO = getInfoFromSSO(user);
        } else {
            loginVO.setState(StateCode.FAIL_500);
            loginVO.setMsg(StateInfo.STATE_500.INFO);
        }
        return loginVO;
    }
}
