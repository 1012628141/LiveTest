//package com.readyidu.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
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
//* RouterMapController Tester.
//*
//* @author <Authors name>
//* @since <pre>11/16/2017</pre>
//* @version 1.0
//*/
//public class RouterMapControllerTest extends TestBaseConfig{
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
//* Method: getAllChannelMap()
//*
//*/
//@Test
//public void testGetAllChannelMap() throws Exception {
//    String json = this.mockMvc
//            .perform((get("/router/channel/getMapper.do")
//            ))
//            .andExpect(status().isOk())
//            .andReturn().getResponse().getContentAsString();
//    System.out.println(json);
//    JSONObject jsonObject = JSONObject.parseObject(json);
//    String code = jsonObject.getString("code");
//    JSONArray dataList = JSONArray.parseArray(jsonObject.getString("data"));
//    assertTrue(code.equals("200"));
//    assertTrue(!dataList.isEmpty());
//}
//
///**
//*
//* Method: removeMapper(HttpServletRequest request)
//*
//*/
//@Test
//public void testRemoveMapper() throws Exception {
//    String json = this.mockMvc
//            .perform((post("/router/channel/removeMapper.do")
//                    .param("id","51")
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
//* Method: addMapper()
//*
//*/
//@Test
//public void testAddMapper() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: deleteMapper()
//*
//*/
//@Test
//public void testDeleteMapper() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: addMapper(HttpServletRequest request)
//*
//*/
//@Test
//public void testAddMapperRequest() throws Exception {
////    String json = this.mockMvc
////            .perform((post("/router/channel/addMapper.do")
////                    .param("content","测试测试1,测试频道|测试测试2,测试频道")
////            ))
////            .andExpect(status().isOk())
////            .andReturn().getResponse().getContentAsString();
////    System.out.println(json);
////    JSONObject jsonObject = JSONObject.parseObject(json);
////    String code = jsonObject.getString("code");
////    assertTrue(code.equals("200"));
//}
//
///**
//*
//* Method: mapCacheExpire()
//*
//*/
//@Test
//public void testMapCacheExpire() throws Exception {
////TODO: Test goes here...
//}
//
//
//}
