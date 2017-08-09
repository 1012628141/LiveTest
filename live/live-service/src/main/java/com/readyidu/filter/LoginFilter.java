package com.readyidu.filter;

import com.readyidu.model.User;
import com.readyidu.util.NullUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
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
        String[] notFilter=new String[]{"/user/loginInit.do","/user/login.do","/channel/chanenel.do","/source/source.do"};
        String url =request.getRequestURI();
        System.out.println(url);
        boolean doFilter=true;
        for (String s : notFilter) {
            if (s.equals(url)) {
                doFilter = false;
            }
        }
        if (doFilter){
            User obj = (User) request.getSession().getAttribute("loginInfo");
            System.out.println(obj);
            if (NullUtil.isNullObject(obj))
            {
                response.sendRedirect("/user/loginInit.do");
            }
        }
        filterChain.doFilter(request,response);
    }
}
