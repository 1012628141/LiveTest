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
 * ChannelController Tester.
 *
 * @author ypf
 * @version 1.0
 */
public class ChannelControllerTest extends TestBaseConfig {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getChannel(HttpServletRequest request, HttpServletResponse response)
     */
    @Test
    public void testGetChannel() throws Exception {
        String json = this.mockMvc
                .perform((get("/channel/channel.do")
                ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String code = jsonObject.getString("code");
        assertTrue(code.equals("200"));
    }

    /**
     * Method: getChannelType(HttpServletRequest request, HttpServletResponse response)
     */
    @Test
    public void testGetChannelType() throws Exception {
        String json = this.mockMvc
                .perform((get("/channel/channelType.do")
                ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String code = jsonObject.getString("code");
        assertTrue(code.equals("200"));
    }

    /**
     * Method: postChannel(HttpServletRequest request, HttpServletResponse response)
     */
    @Test
    public void testPostChannel() throws Exception {
        String json = this.mockMvc
                .perform((post("/channel/channel.do")
                ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String code = jsonObject.getString("code");
        assertTrue(code.equals("200"));
    }

    /**
     * Method: postChannelType(HttpServletRequest request, HttpServletResponse response)
     */
    @Test
    public void testPostChannelType() throws Exception {
        String json = this.mockMvc
                .perform((post("/channel/channelType.do")
                ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String code = jsonObject.getString("code");
        assertTrue(code.equals("200"));
    }

    /**
     * Method: mapCacheExpire()
     */
    @Test
    public void testMapCacheExpire() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: channelPlaybill(HttpServletRequest request)
     */
    @Test
    public void testChannelPlaybill() throws Exception {
        String json = this.mockMvc
                .perform((get("/channel/channelPlaybill.do")
                        .param("channelId", "1")
                ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        String code = jsonObject.getString("code");
        assertTrue(code.equals("200"));
    }


}
