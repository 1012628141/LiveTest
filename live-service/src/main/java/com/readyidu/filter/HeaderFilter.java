package com.readyidu.filter;

import com.readyidu.pojo.RequestParamModel;
import com.readyidu.util.NullUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 123 on 2017/12/13.
 */
public class HeaderFilter extends OncePerRequestFilter {

    public static  ThreadLocal<RequestParamModel> paramModel = new ThreadLocal<RequestParamModel>();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String remoteHost = httpServletRequest.getRemoteHost();
        String version = httpServletRequest.getHeader("version");
        if (!NullUtil.isNullObject(version)){
            version = version.replaceAll("\\.","");
        }
        String lat = httpServletRequest.getHeader("lat");
        String appId = httpServletRequest.getHeader("appId");
        String password = httpServletRequest.getHeader("password");
        String lon = httpServletRequest.getHeader("lon");
        String platform = httpServletRequest.getHeader("platform");
        String locationId = httpServletRequest.getHeader("locationId");
        /*此处个人测试用，不作为最终处理方法*/
        int account=0;
        if(httpServletRequest.getHeader("account")!=null){
           account = Integer.valueOf(httpServletRequest.getHeader("account"));
        }

        String deviceId = httpServletRequest.getHeader("deviceId");
        paramModel.set(new RequestParamModel(remoteHost,version,lat,appId,password,lon,platform,locationId,account,deviceId));
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
