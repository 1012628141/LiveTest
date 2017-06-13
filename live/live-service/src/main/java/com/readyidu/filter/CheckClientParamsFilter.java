package com.readyidu.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 增加filter 校验参数的合法性
 *
 * @author yuzhang
 */
public class CheckClientParamsFilter implements Filter {

    // 无需校验的 url
    private Set<String> excludes;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.excludes = new HashSet<String>();
        String excludes = config.getInitParameter("excludedPages");
        Collections.addAll(this.excludes, excludes.split(","));
    }

    /**
     * 加密参数，并对比判断参数是否在传送过程中修改
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
