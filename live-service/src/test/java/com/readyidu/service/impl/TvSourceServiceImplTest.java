//package com.readyidu.service.impl;
//
//import com.readyidu.mapper.ChannelMapper;
//import com.readyidu.model.Channel;
//import com.readyidu.model.ChannelSource;
//import com.readyidu.model.ChannelType;
//import com.readyidu.service.*;
//import com.readyidu.tools.TestBaseConfig;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * TvSourceServiceImpl Tester.
// *
// * @author <Authors name>
// * @version 1.0
// * @since <pre>11/15/2017</pre>
// */
//public class TvSourceServiceImplTest extends TestBaseConfig {
//
//    @Resource(name = "channelMapper")
//    private ChannelMapper channelMapper;
//
//    @Resource(name = "channelService")
//    private ChannelService channelService;
//
//    @Resource(name = "routerService")
//    private RouterService routerService;
//
//    @Resource(name = "sourceService")
//    SourceService sourceService;
//
//    @Resource(name = "channelSourceService")
//    ChannelSourceService channelSourceService;
//
//    @Resource(name = "ipDataService")
//    IpDataService ipDataService;
//
//    @Before
//    public void before() throws Exception {
//    }
//
//    @After
//    public void after() throws Exception {
//    }
//
//    /**
//     * 已弃用
//     * Method: selectChannelByKey(String key)
//     */
//    @Test
//    public void testSelectChannelByKey() throws Exception {
////    String key = "中央一套";
////    List<Channel> channels = channelService.selectChannelByKey(key);
////    System.out.println(channels.get(0).getChannel());
////    assertTrue(channels.size()>0);
////    assertTrue(channels.get(0).getChannel().equals("CCTV1"));
//    }
//
//    /**
//     * Method: getSourceByIp(String sourceUri, String IpAdress)
//     */
//    @Test
//    public void testGetSourceByIp() throws Exception {
//        String sourceUri = "sourceUri://cctv_cntv/cctv1";
//        String source = sourceService.getSource(sourceUri);
//        assertTrue(!source.isEmpty());
//    }
//
//    /**
//     * 已弃用
//     * Method: getSource(String sourceUri)
//     */
//    @Test
//    public void testGetSource() throws Exception {
//    }
//
//    /**
//     * Method: getChannelList()
//     */
//    @Test
//    public void testGetChannelList() throws Exception {
//        List<Channel> channelList = channelService.selectAllNew();
//        assertTrue(!channelList.isEmpty());
//        List<Channel> movieList = channelService.getMovieToSource();
//        assertTrue(!movieList.isEmpty());
//    }
//
//    /**
//     * Method: channelPlaybill(String channelId)
//     */
//    @Test
//    public void testChannelPlaybill() throws Exception {
//        String channelId = "1";
//        Map<String, Object> playBill = channelService.channelPlaybill(channelId);
//        System.out.println(playBill);
//        assertTrue(!playBill.isEmpty());
//    }
//
//    /**
//     * Method: channelType()
//     */
//    @Test
//    public void testChannelType() throws Exception {
//        List<ChannelType> channelTypeList = channelService.getChannelType();
//        assertTrue(!channelTypeList.isEmpty());
//    }
//
//    /**
//     * Method: selectChannelInfoByKey(String key)
//     */
//    @Test
//    public void testSelectChannelInfoByKey() throws Exception {
//        String key = "中央一套";
//        List<Channel> channels = channelService.selectChannelByKey(key);
//        assertTrue(!channels.isEmpty());
//        for (Channel channel : channels)
//        {
//            System.out.println(channel.getChannel());
//            Map<String, Object> playBill = channelService.channelPlaybill(channel.getId().toString());
//            System.out.println(playBill);
//            assertTrue(!playBill.isEmpty());
//        }
//    }
//
//    /**
//     * Method: insertReport(String source)
//     */
//    @Test
//    public void testInsertReport() throws Exception {
//        String source = "http://stream.jinhua.com.cn/xwzh/app/live.m3u8";
//        ChannelSource channelDeath = channelSourceService.getDeathBySource(source);
//        if (channelDeath == null) {
//            if (channelSourceService.updateIsDelete(source) == 0) {
//                assertTrue(1==0);
//            }
//        }
//    }
//
//    /**
//     * Method: checkOperator(String IpAdress)
//     */
//    @Test
//    public void testCheckOperator() throws Exception {
////TODO: Test goes here...
//    }
//
//
//}
