package com.readyidu.service.impl;

import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.Channel;
import com.readyidu.model.ChannelType;
import com.readyidu.service.*;
import com.readyidu.tools.TestBaseConfig;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import javax.annotation.Resource;
import javax.swing.text.html.parser.TagElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * TvSourceServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/15/2017</pre>
 */
public class TvSourceServiceImplTest extends TestBaseConfig {

    @Resource(name = "channelMapper")
    private ChannelMapper channelMapper;

    @Resource(name = "channelService")
    private ChannelService channelService;

    @Resource(name = "routerService")
    private RouterService routerService;

    @Resource(name = "sourceService")
    SourceService sourceService;

    @Resource(name = "channelSourceService")
    ChannelSourceService channelSourceService;

    @Resource(name = "ipDataService")
    IpDataService ipDataService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectChannelByKey(String key)
     */
    @Test
    public void testSelectChannelByKey() throws Exception {
//    String key = "中央一套";
//    List<Channel> channels = channelService.selectChannelByKey(key);
//    System.out.println(channels.get(0).getChannel());
//    assertTrue(channels.size()>0);
//    assertTrue(channels.get(0).getChannel().equals("CCTV1"));
    }

    /**
     * Method: getSourceByIp(String sourceUri, String IpAdress)
     */
    @Test
    public void testGetSourceByIp() throws Exception {
        String sourceUri = "sourceUri://cctv_cntv/cctv1";
        String source = sourceService.getSource(sourceUri);
        assertTrue(!source.isEmpty());
    }

    /**
     * Method: getSource(String sourceUri)
     */
    @Test
    public void testGetSource() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getChannelList()
     */
    @Test
    public void testGetChannelList() throws Exception {
        List<Channel> channelList = channelService.selectAllNew();
        assertTrue(!channelList.isEmpty());
        List<Channel> movieList = channelService.getMovieToSource();
        assertTrue(!movieList.isEmpty());
    }

    /**
     * Method: channelPlaybill(String channelId)
     */
    @Test
    public void testChannelPlaybill() throws Exception {
        String channelId = "1";
        Map<String, Object> playBill = channelService.channelPlaybill(channelId);
        System.out.println(playBill);
        assertTrue(!playBill.isEmpty());
    }

    /**
     * Method: channelType()
     */
    @Test
    public void testChannelType() throws Exception {
        List<ChannelType> channelTypeList = channelService.getChannelType();
        assertTrue(!channelTypeList.isEmpty());
    }

    /**
     * Method: selectChannelInfoByKey(String key)
     */
    @Test
    public void testSelectChannelInfoByKey() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: insertReport(String source)
     */
    @Test
    public void testInsertReport() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: checkOperator(String IpAdress)
     */
    @Test
    public void testCheckOperator() throws Exception {
//TODO: Test goes here... 
    }


} 
