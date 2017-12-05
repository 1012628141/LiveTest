//package com.readyidu.service.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.readyidu.constants.NetworkCode;
//import com.readyidu.mapper.ChannelMapper;
//import com.readyidu.model.*;
//import com.readyidu.service.*;
//import com.readyidu.source.base.LiveManager;
//import com.readyidu.tools.TestBaseConfig;
//import com.readyidu.util.HttpUtil;
//import com.readyidu.util.JsonResult;
//import com.readyidu.util.NullUtil;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ExecutionException;
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
//    @Resource(name = "lunBoFromService")
//    LunBoFromService lunBoFromService ;
//
//    @Resource(name = "liveManager")
//    LiveManager liveManager ;
//
//    @Resource(name = "cacheService")
//    CacheService cacheService;
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
//        List<DemandChannel> movieList = channelService.getMovieToSource();
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
//    @Test
//    public void testGetTypeList() throws Exception{
//        int id = 702 ;
//        List<ChannelType> channelTypeList = channelService.getTypeList();
//        String type = channelService.getTypeById(id);
//        type = type.replace("省","").replace("市","").replace("自治区","");
//        for(int i=0;i<channelTypeList.size();i++){
//            // 遍历集合，若找到城市则将该城市的频道分类与浙江交换
//            ChannelType c = channelTypeList.get(i);
//            String p = c.getType();
//            if(type.equals(p)){
//                if(i==2){
//                    channelTypeList.get(2).setCategoryId(0);
//                    break;
//                }
//                ChannelType temp = channelTypeList.get(i);
//                channelTypeList.set(i,channelTypeList.get(2)) ;
//                channelTypeList.set(2,temp);
//                channelTypeList.get(2).setCategoryId(0);
//                channelTypeList.get(i).setCategoryId(1);
//                break;
//            }
//        }
//        List<ChannelType> newChannelTypeList = channelTypeList.subList(0,12);
//        System.out.println(JsonResult.toString(NetworkCode.CODE_SUCCESS, newChannelTypeList));
//        assertTrue(type.equals(channelTypeList.get(2).getType()));
//    }
//
//    public String checkOperator(String IpAdress) {
//        String IPIP_TOKEN = "30e93b06b4a738f4bf233566a83f30f02ba6c093";
//        IpData ipData = new IpData(IpAdress);
//        String searchResult = ipDataService.SelectIpOperator(ipData);
//        if (!NullUtil.isNullObject(searchResult)) {
//            return searchResult;
//        }
//        String httpResult = HttpUtil.httpGet("http://ipapi.ipip.net/find?addr=" + IpAdress, IPIP_TOKEN);
//        JSONObject jsonResult = JSON.parseObject(httpResult);
//        String data = jsonResult.getString("data");
//        String[] info = data.split(",");
//        String operator = info[4].replace("\"", "");
//        if (!NullUtil.isNullObject(operator))
//        {
//            ipData.setOperator(operator);
//            ipDataService.insertIpData(ipData);
//        }
//        return operator;
//    }
//
////    public void testGetNewChannelListByTypeId() throws Exception{
//////        String cacheKey = "channel_" + "1"+"_date" ;
////        String cacheKey = "channel_675_date";
////        String cacheObj = cacheService.get(cacheKey);
////        System.out.println(cacheObj);
////    }
//    @Test
//    public void selectTvShowByChannelId() throws Exception{
//        Integer channelId = 8033;
//        List<NewChannel>channelList = lunBoFromService.selectTvShowByChannelId(channelId);
//        System.out.println(JsonResult.toString(NetworkCode.CODE_SUCCESS, channelList));
//        assertTrue(!channelList.isEmpty());
//    }
//}
