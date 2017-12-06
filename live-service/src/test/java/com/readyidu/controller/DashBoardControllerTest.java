package com.readyidu.controller;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.tools.TestBaseConfig;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* DashBoardController Tester.
*
* @author <Authors name>
* @since <pre>11/16/2017</pre>
* @version 1.0
*/
public class DashBoardControllerTest extends TestBaseConfig{

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: dashBoardIndex(HttpServletRequest request)
*
*/
@Test
public void testDashBoardIndex() throws Exception {
}

/**
*
* Method: pageLoad(HttpServletRequest request)
*
*/
@Test
public void testPageLoad() throws Exception {
    String json = this.mockMvc
            .perform((post("/pageLoad.do")
                    .param("pageno","1")
            ))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    System.out.println(json);
    JSONObject jsonObject = JSONObject.parseObject(json);
    String code = jsonObject.getString("code");
    assertTrue(code.equals("200"));
}

/**
*
* Method: pageDeathLoad(HttpServletRequest request)
*
*/
@Test
public void testPageDeathLoad() throws Exception {
    String json = this.mockMvc
            .perform((post("/pageDeathLoad.do")
                    .param("pageno","1")
            ))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    System.out.println(json);
    JSONObject jsonObject = JSONObject.parseObject(json);
    String code = jsonObject.getString("code");
    assertTrue(code.equals("200"));
}

/**
*
* Method: pageMapLoad(HttpServletRequest request)
*
*/
@Test
public void testPageMapLoad() throws Exception {
    String json = this.mockMvc
            .perform((post("/pageMapLoad.do")
                    .param("pageno","1")
            ))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    System.out.println(json);
    JSONObject jsonObject = JSONObject.parseObject(json);
    String code = jsonObject.getString("code");
    assertTrue(code.equals("200"));
}

}
