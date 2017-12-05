//package com.readyidu.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.readyidu.tools.TestBaseConfig;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//
//import static org.junit.Assert.assertTrue;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
//* DeathChannelController Tester.
//*
//* @author <Authors name>
//* @since <pre>11/16/2017</pre>
//* @version 1.0
//*/
//public class DeathChannelControllerTest extends TestBaseConfig{
//
//@Before
//public void before() throws Exception {
//}
//
//@After
//public void after() throws Exception {
//}
//
///**
//*
//* Method: insertReport(HttpServletRequest request)
//*
//*/
//@Test
//public void testInsertReport() throws Exception {
//    String json = this.mockMvc
//            .perform((post("/report/add.do")
//                    .param("sourceUri", "http://stream.jinhua.com.cn/xwzh/app/live.m3u8")
//            ))
//            .andExpect(status().isOk())
//            .andReturn().getResponse().getContentAsString();
//    System.out.println(json);
//    JSONObject jsonObject = JSONObject.parseObject(json);
//    String code = jsonObject.getString("code");
//    assertTrue(code.equals("200"));
//}
//
///**
//*
//* Method: auditPass(Integer sourceid, boolean status)
//*
//*/
//@Test
//public void testAuditPass() throws Exception {
// }
//}
