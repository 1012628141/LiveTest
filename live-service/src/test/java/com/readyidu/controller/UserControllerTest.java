package com.readyidu.controller;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.tools.TestBaseConfig;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
* UserController Tester.
*
* @author <Authors name>
* @since <pre>11/16/2017</pre>
* @version 1.0
*/
public class UserControllerTest extends TestBaseConfig{

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: login(HttpServletRequest request, RedirectAttributes model, HttpServletResponse response)
*
*/
@Test
public void testLogin() throws Exception {
}

/**
*
* Method: loginInit(@ModelAttribute("msg") String msg)
*
*/
@Test
public void testLoginInit() throws Exception {
    String json = this.mockMvc
            .perform((get("/user/loginInit.do")
            ))
            .andExpect(view().name("pages/login"))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    System.out.println(json);
}

/**
*
* Method: loginOut(HttpServletRequest request)
*
*/
@Test
public void testLoginOut() throws Exception {
}


}
