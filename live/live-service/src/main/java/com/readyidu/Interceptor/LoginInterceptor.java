package com.readyidu.Interceptor;

import com.readyidu.model.User;
import com.readyidu.util.NullUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2017/8/9.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String[] notFilter=new String[]{"/user/loginInit.do","/user/login.do","/channel/chanenel.do","/source/source.do"};
        String url =request.getRequestURI();
        boolean doInterceptor=true;
        for (String s : notFilter) {
            if (s.equals(url)) {
                doInterceptor = false;
            }
        }
        if (doInterceptor){
            User obj = (User) request.getSession().getAttribute("loginInfo");
            if (NullUtil.isNullObject(obj))
            {
                response.sendRedirect("/user/loginInit.do");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
