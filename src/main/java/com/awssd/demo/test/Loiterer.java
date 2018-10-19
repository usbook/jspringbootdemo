package com.awssd.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loiterer implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(Loiterer.class);
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    // 登陆验证拦截器
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        System.out.println("hello");
        String path = arg0.getServletPath();
        if (path.contains("/Index/1")||path.contains("/Index1")) {
            return true;
        } else {
            Object admin = (Object) arg0.getSession().getAttribute("luji");
            if (admin == null) {
                arg1.sendRedirect("https://www.baidu.com");
                return false;
            } else {
                //正常往下执行
                return true;
            }
        }
    }
//@Override
//public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//    System.out.printf("preHandle被调用");
//    log.info("preHandle被调用");
//    return false;    //如果false，停止流程，api被拦截
//}
//
//    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle被调用");
//    }
//
//    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("afterCompletion被调用");
//    }
}