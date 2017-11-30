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
* WebChannelController Tester.
*
* @author ypf
* @since <pre>ʮһ�� 15, 2017</pre>
* @version 1.0
*/
public class WebChannelControllerTest extends TestBaseConfig{

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: addChannel(@PathVariable String channelName)
*
*/
@Test
public void testAddChannel() throws Exception {
    String json = this.mockMvc
            .perform((get("/webChannel/addChannel/ceshi")
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
* Method: addSource(HttpServletRequest request)
*
*/
@Test
public void testAddSource() throws Exception {
    String json = this.mockMvc
            .perform((post("/webChannel/addSource.do")
                    .param("channelId","3000")
                    .param("sourceUri","sourceUri://test/test")
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
* Method: modifySource(HttpServletRequest request)
*
*/
@Test
public void testModifySource() throws Exception {
    String json = this.mockMvc
            .perform((post("/webChannel/modifySource.do")
                    .param("channelId","893")
                    .param("source","sourceUri://test/test")
                    .param("sourceId","3000")
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
* Method: removeSource(HttpServletRequest request)
*
*/
@Test
public void testRemoveSource() throws Exception {
    String json = this.mockMvc
            .perform((post("/webChannel/removeSource.do")
                    .param("channelId","3000")
                    .param("sourceId","0")
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
* Method: changeType(HttpServletRequest request)
*
*/
@Test
public void testChangeType() throws Exception {
    String json = this.mockMvc
            .perform((post("/webChannel/changeType.do")
                    .param("channelId","3000")
                    .param("typeId","200")
            ))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    System.out.println(json);
    JSONObject jsonObject = JSONObject.parseObject(json);
    String code = jsonObject.getString("code");
    assertTrue(code.equals("200"));
}

/**
<<<<<<< HEAD
* 已弃用
=======
*
>>>>>>> a213f85b06352faf770b15653bf89903ba8d5d3d
* Method: removeChannel(HttpServletRequest request)
*
*/
@Test
public void testRemoveChannel() throws Exception {
}

/**
*
* Method: checkChannel(HttpServletRequest request)
*
*/
@Test
public void testCheckChannel() throws Exception {
//    String json = this.mockMvc
//            .perform((get("/webChannel/checkSource.do")
//                    .param("sourceUri","http://lms.csytv.com/Live/125/live/livestream.m3u8")
//            ))
//            .andExpect(status().isOk())
//            .andReturn().getResponse().getContentAsString();
//    System.out.println(json);
//    JSONObject jsonObject = JSONObject.parseObject(json);
//    String code = jsonObject.getString("code");
//    assertTrue(code.equals("10000"));
}

/**
*
* Method: sortChange(@RequestParam(value = "sourceList[]") int[] sourceList, int channelId, HttpServletRequest request)
*
*/
@Test
public void testSortChange() throws Exception {
//    String json = this.mockMvc
//            .perform((post("/webChannel/sortChange.do")
//                    .param("channelId","3000")
//                    .param("sourceList","[]")
//            ))
//            .andExpect(status().isOk())
//            .andReturn().getResponse().getContentAsString();
//    System.out.println(json);
//    JSONObject jsonObject = JSONObject.parseObject(json);
//    String code = jsonObject.getString("code");
//    assertTrue(code.equals("200"));
}

/**
*
* Method: getData()
*
*/
@Test
public void testGetData() throws Exception {
}

/**
*
* Method: setData(HashMap<String, String> data)
*
*/
@Test
public void testSetData() throws Exception {
}

/**
*
* Method: getCode()
*
*/
@Test
public void testGetCode() throws Exception {
}

/**
*
* Method: setCode(Integer code)
*
*/
@Test
public void testSetCode() throws Exception {
}


/**
*
* Method: checkSource(String sourceUri)
*
*/
@Test
public void testCheckSource() throws Exception {
}

}
