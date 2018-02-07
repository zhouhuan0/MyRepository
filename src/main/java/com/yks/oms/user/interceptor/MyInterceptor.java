package com.yks.oms.user.interceptor;

import com.yks.oms.user.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器
 *  @author zhouhuan 
 *  @version 1.0
 *  @see  
 *  @since JDK1.8
 *  @date 2018年2月1日
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 进入controller方法之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取session
        HttpSession session = httpServletRequest.getSession();
        //从session中获取用户信息
        User user = (User) session.getAttribute("user");
        httpServletResponse.setContentType("text/html;charset=utf-8");
        //用户信息存在就放行,不存在就拦截
        if (user == null) {
            httpServletResponse.getWriter().print("<h2>请登录账号</h2>");
            return false;
        } else {
            String ticket = httpServletRequest.getHeader("ticket");
            if (user.getTicket().equals(ticket)) {
                return true;
            }
            httpServletResponse.getWriter().print("<h2>票据不正确</h2>");
            return false;
        }
    }

    /**
     * 进入controller方法之后，渲染视图之前调用
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 完成整个请求之后调用
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
