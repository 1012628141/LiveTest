package com.readyidu.controller;

import com.readyidu.constants.NetworkCode;
import com.readyidu.model.User;
import com.readyidu.service.CacheService;
import com.readyidu.service.UserService;
import com.readyidu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2017/8/9.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CacheService cacheService;
    @RequestMapping(value = "login.do",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public ModelAndView login(HttpServletRequest request, RedirectAttributes model, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        int code = userService.login(request);
        switch (code){
            case NetworkCode.ERROR_CODE_400:
                model.addFlashAttribute("msg","邮箱／密码不能为空");
                modelAndView.setViewName("redirect:loginInit.do");
                break;
            case NetworkCode.ERROR_CODE_412:
                model.addFlashAttribute("msg","邮箱／密码错误");
                modelAndView.setViewName("redirect:loginInit.do");
                break;
            case NetworkCode.CODE_SUCCESS:
                model.addFlashAttribute("token",request.getSession().getId()+"loginInfo");
                Cookie cookie = new Cookie("token", request.getSession().getId() + "loginInfo");
                cookie.setMaxAge(1800);
                cookie.setPath("/");
                response.addCookie(cookie);
                modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
    @RequestMapping(value = "loginInit.do",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public ModelAndView loginInit(@ModelAttribute("msg") String msg){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("pages/login");
        modelAndView.addObject("msg",msg);
        return modelAndView;
    }
    @RequestMapping(value = "loginOut.do",method = RequestMethod.GET,produces =  "application/json; charset=utf-8")
    public ModelAndView loginOut(HttpServletRequest request){
        cacheService.del(request.getSession().getId()+"loginInfo");
        return new ModelAndView("redirect:loginInit.do");
    }
}
