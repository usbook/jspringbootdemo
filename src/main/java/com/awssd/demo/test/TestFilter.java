package com.awssd.demo.test;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(value = "/Index1")
public class TestFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session=((HttpServletRequest) servletRequest).getSession();
        if(session.getAttribute("luji") == null)
        {

            response.sendRedirect("https://www.baidu.com");
            return;
        }

        System.out.printf("过滤器实现");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

