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
* SourceController Tester. 
* 
* @author <Authors name> 
* @since <pre>11/16/2017</pre> 
* @version 1.0 
*/ 
public class SourceControllerTest extends TestBaseConfig{

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getChannelType(HttpServletRequest request, HttpServletResponse response) 
* 
*/ 
@Test
public void testGetChannelType() throws Exception {
    String json = this.mockMvc
            .perform((get("/source/source.do")
                    .param("sourceUri","sourceUri://chengdu/chengdu10/source_cditv_10:1")
            ))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    System.out.println(json);
    JSONObject jsonObject = JSONObject.parseObject(json);
    String code = jsonObject.getString("code");
    String source = JSONObject.parseObject(jsonObject.getString("data")).getString("source");
    System.out.println(source);
    assertTrue(code.equals("200"));
    assertTrue(!source.isEmpty());
} 

/** 
* 
* Method: postChannel(HttpServletRequest request, HttpServletResponse response) 
* 
*/ 
@Test
public void testPostChannel() throws Exception {
    String json = this.mockMvc
            .perform((post("/source/source.do")
                    .param("sourceUri","sourceUri://chengdu/chengdu10/source_cditv_10:1")
            ))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    System.out.println(json);
    JSONObject jsonObject = JSONObject.parseObject(json);
    String code = jsonObject.getString("code");
    String source = JSONObject.parseObject(jsonObject.getString("data")).getString("source");
    System.out.println(source);
    assertTrue(code.equals("200"));
    assertTrue(!source.isEmpty());
} 


} 
