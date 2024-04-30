package com.ztf.boot.fi.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
@WebFilter(filterName = "customFilter", urlPatterns = {"/*"})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("CustomFilter 处理请求之前进行禁词处理...");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("CustomFilter 处理接口请求之后，做一些响应的处理...");
    }

    @Override
    public void destroy() {
        log.info("CustomFilter 销毁");
    }
}
