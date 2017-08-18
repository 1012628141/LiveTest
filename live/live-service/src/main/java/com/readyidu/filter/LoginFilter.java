package com.readyidu.filter;

import com.readyidu.model.User;
import com.readyidu.util.NullUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 123 on 2017/8/9.
 */
public class LoginFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String[] notFilter=new String[]{
                "/user/loginInit.do"
                ,"/user/login.do",
                "/channel/channel.do",
                "/source/source.do",
                "/router/channel/getMapper.do",
                "/channel/channelType.do",
                "/report/add.do"
        };
        String url =request.getRequestURI();
        boolean doFilter=true;
        for (String s : notFilter) {
            if (s.equals(url)) {
                doFilter = false;
            }
        }
        if(url.contains("/css")||url.contains("/img")|url.contains("/js"))
        {
            doFilter = false;
        }
        if (doFilter) {
            String loginInfo = null;
            Cookie[] cookies;
            cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")){
                    loginInfo=cookie.getValue();
                }
            }
             if (NullUtil.isNullObject(loginInfo)) {
                response.sendRedirect("/user/loginInit.do");
                return;
            }
        }
        filterChain.doFilter(request,response);
    }
}
