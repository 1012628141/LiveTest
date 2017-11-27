package com.readyidu.controller;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.tools.TestBaseConfig;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* TvPlayController Tester.
*
* @author <Authors name>
* @since <pre>11/16/2017</pre>
* @version 1.0
*/
public class TvPlayControllerTest extends TestBaseConfig{

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: pushPlayType()
*
*/
@Test
public void testPushPlayType() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: tvPlayType()
*
*/
@Test
public void testTvPlayType() throws Exception {
    String json = this.mockMvc
            .perform((post("/play/tvPlayType.do")
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
* Method: tvsource(String source)
*
*/
@Test
public void testTvsource() throws Exception {
    String json = this.mockMvc
            .perform((post("/play/tvsource")
            ))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
    System.out.println(json);
    JSONObject jsonObject = JSONObject.parseObject(json);
    String code = jsonObject.getString("code");
    assertTrue(code.equals("200"));
}


}
