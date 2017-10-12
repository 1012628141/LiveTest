package com.readyidu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.readyidu.mapper.BillFromMapper;
import com.readyidu.mapper.ChannelSourceMapper;
import com.readyidu.model.*;
import com.readyidu.playbill.base.OriginManager;
import com.readyidu.playbill.model.Program;
import com.readyidu.service.*;
import com.readyidu.mapper.ChannelMapper;
import com.readyidu.mapper.ChannelTypeMapper;
import com.readyidu.util.CacheUtil;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Service("channelService")
public class ChannelServiceImpl extends BaseService implements
        ChannelService {

    @Resource(name = "channelMapper")
    private ChannelMapper channelMapper;

    @Resource(name = "channelTypeMapper")
    private ChannelTypeMapper channelTypeMapper;

    @Resource(name = "cacheService")
    private CacheService cacheService;
    @Resource(name = "channelSourceMapper")
    private ChannelSourceMapper channelSourceMapper;

    @Resource(name = "movieService")
    private MovieService movieService;

    @Resource(name = "routerService")
    private RouterService routerService;

    @Resource(name = "billFromMapper")
    private BillFromMapper billFromMapper;

    @Resource(name = "originManager")
    private OriginManager originManager;

    private static final String CACHE_NAME = "channel_";

    @Override
    public List<Channel> getChannelList() {
        // TODO Auto-generated method stub
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelList";

        List<Channel> channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, Channel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectAll();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelList),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }

    @Override
    public List<Channel> getChannelListWithDeathSource(String source) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "deathChannelList"+source;
        List<Channel> deathChannelList=null;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            deathChannelList = JSON.parseArray(cacheObj, Channel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            deathChannelList = channelMapper.selectBySource(source);
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(deathChannelList),
                    CacheService.CACHE_TIMEOUT);
        }
        System.out.println(deathChannelList.toString());
        return deathChannelList;
//        return channelMapper.selectBySource(source);
    }

    @Override
    public List<ChannelType> getChannelType() {
        // TODO Auto-generated method stub
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelType";

        List<ChannelType> channelType = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelType = JSON.parseArray(cacheObj, ChannelType.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelType = channelTypeMapper.selectAll();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelType),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelType;
    }

    @Override
    public int addChannel(String name) {
        Channel channel = new Channel();
        channel.setChannel(name);
        channel.setTypeid("62");
        return channelMapper.insert(channel);
    }

    @Override
    public Channel getChannel(Integer id) {
        return channelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateSource(Integer channelId, String source) {
        ChannelSource channelSource = new ChannelSource();
        channelSource.setSource(source);
        channelSource.setParentid(channelId);
        int sort = channelSourceMapper.countSourceByParentId(channelId)+1;
        channelSource.setSort(sort);
        return channelSourceMapper.importData(channelSource);
//        Channel channel = channelMapper.selectByPrimaryKey(channelId);
//        if (channel != null) {
//            String originSource = channel.getSource();
//
//            if (source.startsWith("http")
//                    || source.startsWith("https")
//                    || source.startsWith("rtmp")
//                    || source.startsWith("sourceUri")) {
//                StringBuilder builder = new StringBuilder();
//                if (!TextUtils.isEmpty(originSource)) {
//                    builder.append(originSource);
//                    builder.append("|");
//                    builder.append(source);
//                } else {
//                    builder.append(source);
//                }
//
//                channel.setSource(builder.toString());
//                return channelMapper.updateByPrimaryKey(channel);
//            }
//        }
    }

    @Override
    public int removeSource(Integer channelId, Integer sourceId) {
//        Channel channel = channelMapper.selectByPrimaryKey(channelId);
        List<ChannelSource> channleList = channelSourceMapper.selectSourceByParentId(channelId);
        int deleteId=0;
        if (sourceId<channleList.size()){
            if (channleList.size()!=0){
                for (int i = 0; i < channleList.size(); i++) {
                    if (i==sourceId){
                        deleteId=channleList.get(i).getId();
                    }
                }
            }
            return  channelSourceMapper.delectSourceByid(deleteId);
        }
        return 0;
//
//        if (channel != null) {
//            String originSource = channel.getSource();
//
//            if (!TextUtils.isEmpty(originSource)) {
//                String[] sources = originSource.split("\\|");
//                StringBuilder builder = new StringBuilder();
//                for (int i = 0; i < sources.length; i++) {
//                    if (i == sourceId) {
//                        continue;
//                    }
//                    builder.append(sources[i]);
//                    builder.append("|");
//                }
//                channel.setSource(builder.toString());
//                return channelMapper.updateByPrimaryKey(channel);
//            }
//        }
//
//        return 0;
    }

    @Override
    public int changeType(Integer channelId, String typeId) {

        Channel channel = channelMapper.selectByPrimaryKey(channelId);
        if (channel != null) {
            channel.setTypeid(typeId);
            return channelMapper.updateByPrimaryKey(channel);
        }

        return 0;
    }
    @Override
    public List<Channel> getMovieToSource() {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "movielList";
        String cacheObj = cacheService.get(cacheKey);
        List<Channel> channelList = null;
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, Channel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            List<Movie> movieList = movieService.selectAllMovie();
            channelList = new ArrayList<>();
            for (Movie movie: movieList){
                Channel channel = new Channel();
                channel.setId(movie.getId()+10000);
                channel.setChannel(movie.getTitle());
                channel.setSource("sourceUri://movie/tianyi/"+movie.getContid());
                channel.setTypeid("1400");
                channelList.add(channel);
            }
            movieList = movieService.selectAllTrailer();
            for (Movie movie: movieList){
                Channel channel = new Channel();
                channel.setId(movie.getId()+10000);
                channel.setChannel(movie.getTitle());
                channel.setSource("sourceUri://movie/tianyi/"+movie.getContid());
                channel.setTypeid("1500");
                channelList.add(channel);
            }
            // 信息缓存5分钟
            cacheService.set(cacheKey,JSON.toJSONString(channelList),CacheService.CACHE_TIMEOUT);;
        }
        return channelList;
    }

    @Override
    public Map<String, Object> channelPlaybill(String channelId) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "PLAYBILL"+channelId;
        String programStr = cacheService.get(cacheKey);
        Map<String, Object> programMap =null;
        BillFromInfo billFromInfo = billFromMapper.
                selectBillFromInfoByChannelId(
                        Integer.valueOf(channelId));
        if (!NullUtil.isNullObject(programStr)) {
            programMap = (Map<String, Object>) JSON.parse(programStr);
        } else {
        if (!NullUtil.isNullObject(billFromInfo)){
            programMap = originManager.getPlaybill(
                    billFromInfo.getFromUrl(),
                    billFromInfo.getOrigin());
            cacheService.set(cacheKey,JSON.toJSONString(programMap),600 );
        }
        }
        return programMap;
    }

    @Override
    public Channel selectChannelByKey(String key) {
        RouterMapping router = routerService.selectByKey(key);
        return channelMapper.selectChannelByChannel(router.getValue());
    }

    @Override
    public int removeChannel(Integer channelId) {
        return channelMapper.deleteByPrimaryKey(channelId);
    }
}