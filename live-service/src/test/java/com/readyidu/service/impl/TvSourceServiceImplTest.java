package com.readyidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.constants.NetworkCode;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.model.*;
import com.readyidu.service.*;
import com.readyidu.source.base.LiveManager;
import com.readyidu.tools.TestBaseConfig;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import javax.annotation.Resource;
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

    @Resource(name = "lunBoFromService")
    LunBoFromService lunBoFromService ;

    @Resource(name = "liveManager")
    LiveManager liveManager ;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 已弃用
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
     * 已弃用
     * Method: getSource(String sourceUri)
     */
    @Test
    public void testGetSource() throws Exception {
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
        String key = "中央一套";
        List<Channel> channels = channelService.selectChannelByKey(key);
        assertTrue(!channels.isEmpty());
        for (Channel channel : channels)
        {
            System.out.println(channel.getChannel());
            Map<String, Object> playBill = channelService.channelPlaybill(channel.getId().toString());
            System.out.println(playBill);
            assertTrue(!playBill.isEmpty());
        }
    }

    /**
     * Method: insertReport(String source)
     */
    @Test
    public void testInsertReport() throws Exception {
        String source = "http://stream.jinhua.com.cn/xwzh/app/live.m3u8";
        ChannelSource channelDeath = channelSourceService.getDeathBySource(source);
        if (channelDeath == null) {
            if (channelSourceService.updateIsDelete(source) == 0) {
                assertTrue(1==0);
            }
        }
    }

    /**
     * Method: checkOperator(String IpAdress)
     */
    @Test
    public void testCheckOperator() throws Exception {
//TODO: Test goes here...
    }
    @Test
    public void testGetSourceByIdNew() throws Exception{

        Integer channelId = 1 ;
        String ipAdress = "192.168.4.178";
        String sourceUri = null;
        List<NewChannelSource> sources = channelSourceService.selectSourceByIdNew(channelId);
        for (NewChannelSource source:sources){
            sourceUri = source.getSource();
            if (sourceUri.startsWith("sourceUri://")){
                sourceUri = sourceService.getSource(source.getSource());
            }
            if (sourceUri.contains("124.160.117.35"))
            {
                String ip = ipAdress;
                String operator = null;
                if (!NullUtil.isNullObject(ip))
                {
                    operator = checkOperator(ip);
                }
                if (NullUtil.isNullObject(operator))
                {
                    operator = "联通";
                }
                switch (operator){
                    case "电信":
                        sourceUri = sourceUri.replace("124.160.117.35","183.134.101.35");
                        break;
                    case "联通":
                        sourceUri = sourceUri.replace("124.160.117.35","218.205.92.125");
                        break;
                    case "移动":
                        sourceUri = sourceUri.replace("124.160.117.35","124.160.117.36");
                        break;
                }
            }
            source.setSource(sourceUri);
        }
       System.out.println(JsonResult.toString(200,sources));
        assertTrue(!sources.isEmpty());
    }

    @Test
    public void testGetDemandByIdNew()throws Exception{
        Integer id = 643 ;
        String source = lunBoFromService.selectDemandById(id);
        if (source.startsWith("sourceUri://")) {
            source = liveManager.getChannelSource(source);
        }
        System.out.println(JsonResult.toString(NetworkCode.CODE_SUCCESS, source));
        assertTrue(!source.isEmpty());
    }

    public String checkOperator(String IpAdress) {
        String IPIP_TOKEN = "30e93b06b4a738f4bf233566a83f30f02ba6c093";
        IpData ipData = new IpData(IpAdress);
        String searchResult = ipDataService.SelectIpOperator(ipData);
        if (!NullUtil.isNullObject(searchResult)) {
            return searchResult;
        }
        String httpResult = HttpUtil.httpGet("http://ipapi.ipip.net/find?addr=" + IpAdress, IPIP_TOKEN);
        JSONObject jsonResult = JSON.parseObject(httpResult);
        String data = jsonResult.getString("data");
        String[] info = data.split(",");
        String operator = info[4].replace("\"", "");
        if (!NullUtil.isNullObject(operator))
        {
            ipData.setOperator(operator);
            ipDataService.insertIpData(ipData);
        }
        return operator;
    }
}
