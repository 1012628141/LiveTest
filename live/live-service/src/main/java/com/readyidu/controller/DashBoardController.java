package com.readyidu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 2017/6/16
 * Created by dylan.
 * Home: http://www.devdylan.cn
 */
@Controller
@RequestMapping(value = "/")
public class DashBoardController {

    @RequestMapping
    public ModelAndView dashBoardIndex() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");

        return modelAndView;
    }
}
