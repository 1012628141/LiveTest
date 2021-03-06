package com.readyidu.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.readyidu.mapper.*;
import com.readyidu.model.*;
import com.readyidu.model.Channel;
import com.readyidu.playbill.base.OriginManager;
import com.readyidu.model.Program;
import com.readyidu.pojo.SourceCheckResult;
import com.readyidu.service.*;
import com.readyidu.source.base.*;
import com.readyidu.util.JsonResult;
import com.readyidu.util.NullUtil;
import com.readyidu.util.PageUtil;
import com.readyidu.util.SourceCheck;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;


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

    @Resource(name = "liveManager")
    private LiveManager liveManager;

    @Resource(name = "lunBoFromService")
    private LunBoFromService lunBoFromService;

    @Resource(name = "playBillInfoMapper")
    private PlayBillInfoMapper playBillInfoMapper;

    private static final String CACHE_NAME = "channel_";

    @Override
    public List<Channel> getChannelList() {
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
        String cacheKey = SERVICE_RBK + CACHE_NAME + "deathChannelList" + source;
        List<Channel> deathChannelList = null;
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
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "getChannelType";

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
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelType"+id.toString();
        Channel channel = null;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channel = JSON.parseObject(cacheObj,Channel.class);
        } else {
            channel = channelMapper.selectByPrimaryKey(id);
            cacheService.set(cacheKey, JSON.toJSONString(channel),
                    CacheService.CACHE_TIMEOUT);
        }
        return channel;
    }

    @Override
    public int updateSource(Integer channelId, String source) {
        ChannelSource channelSource = new ChannelSource();
        channelSource.setSource(source);
        channelSource.setParentid(channelId);
        int sort = channelSourceMapper.countSourceByParentId(channelId) + 1;
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
        String cacheKey = SERVICE_RBK + CACHE_NAME + "selectSourceByParentId"+channelId.toString();
        List<ChannelSource> channelList = null;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj,ChannelSource.class);
        } else {
            channelList = channelSourceMapper.selectSourceByParentId(channelId);
            cacheService.set(cacheKey, JSON.toJSONString(channelList),
                    CacheService.CACHE_TIMEOUT);
        }
        int deleteId = 0;
        if (sourceId < channelList.size()) {
            if (channelList.size() != 0) {
                for (int i = 0; i < channelList.size(); i++) {
                    if (i == sourceId) {
                        deleteId = channelList.get(i).getSourceId();
                    }
                }
            }
            return channelSourceMapper.delectSourceByid(deleteId);
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
    public int reinstateSource(Integer channelId, Integer sourceId) {
        return channelSourceMapper.updateSourceDeleteFlag(channelId, sourceId);
    }


    @Override
    public int changeType(Integer channelId, String typeId) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelType"+channelId;
        Channel channel = null;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channel = JSON.parseObject(cacheObj,Channel.class);
        }else {
            channel = channelMapper.selectByPrimaryKey(channelId);
            cacheService.set(cacheKey, JSON.toJSONString(channel),
                    CacheService.CACHE_TIMEOUT);
        }
        if (channel != null) {
            channel.setTypeid(typeId);
            return channelMapper.updateByPrimaryKey(channel);
        }
        return 0;
    }

    @Override
    public List<DemandChannel> getMovieToSource() {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "movielList";
        String cacheObj = cacheService.get(cacheKey);
        List<DemandChannel> channelList = null;
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, DemandChannel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            List<Movie> movieList = movieService.selectAllMovie();
            channelList = new ArrayList<>();
            for (Movie movie : movieList) {
                DemandChannel channel = new DemandChannel();
                ChannelSource channelSource = new ChannelSource();
                channel.setId(movie.getId() + 10000);
                channel.setChannel(movie.getTitle());
                channelSource.setSource("sourceUri://movie/tianyi/" + movie.getContid());
                List<ChannelSource> sources = new ArrayList<>();
                sources.add(channelSource);
                channel.setSources(sources);
                channel.setTypeid(movie.getSubCategoryId());
                channelList.add(channel);
            }
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelList), CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }


    @Override
    public Map<String, Object> channelPlaybill(String channelId) {
        Map<String, Object> programMap = new HashMap<>();
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelPlaybill"+channelId;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            programMap = JSON.parseObject(cacheObj,Map.class);
        }else {
            Date date = new Date();
            Program program = new Program();
            program.setChannelId(Integer.parseInt(channelId));
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String nowTime = df.format(date);
            program.setDate(nowTime);
            List<Program> todayProgram = playBillInfoMapper.selectBillProgram(program);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE,1);
            date=calendar.getTime();
            String tommorrowTime = df.format(date);
            program.setDate(tommorrowTime);
            List<Program> tommorrowProgram = playBillInfoMapper.selectBillProgram(program);
            programMap.put("todayProgram", todayProgram);
            programMap.put("tommorrowProgram", tommorrowProgram);
//            BillFromInfo billFromInfo = billFromMapper.
//                    selectBillFromInfoByChannelId(
//                            Integer.valueOf(channelId));
//            if (!NullUtil.isNullObject(billFromInfo)) {
//                programMap = originManager.getPlaybill(
//                        billFromInfo.getFromUrl(),
//                        billFromInfo.getOrigin());
//            }
            if (NullUtil.isNullObject(programMap) || programMap.size() == 0) {
                programMap = lunBoFromService.getChannelBill(Integer.valueOf(channelId));
            }
            if (!NullUtil.isNullObject(programMap)) {
                // 信息缓存5分钟
                cacheService.set(cacheKey, JSON.toJSONString(programMap), CacheService.CACHE_TIMEOUT);
            }
        }
        return programMap;
    }

    @Override
    public List<Channel> selectChannelByKey(String key) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelByKey"+key;

        List<Channel> channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, Channel.class);
        }else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectChannelByKey(key);
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelList),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }

    @Override
    public List<Channel> selectAllNew() {
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelNewList";

        List<Channel> channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, Channel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectAllNew();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelList),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }


    @Override
    public List<Channel> selectHotChannel() {
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "hotChannelList";

        List<Channel> channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, Channel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectHotChannel();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelList),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }

//    @Override
//    public Channel selectChannelById(Integer id) {
//        Channel channel = channelMapper.selectChannelById(id);
//        String[] sources = channel.getSource().split("\\|");
//        List<String> trueSources = new ArrayList<>();
//        for (String source : sources)
//        {
//            if(source.contains("sourceUri://"))
//            {
//                String realSource = liveManager.getChannelSource(source);
//                if (!NullUtil.isNullObject(realSource)){
//                    trueSources.add(source);
//                }
//                continue;
//            }
//            SourceCheckResult result = SourceCheck.playCheck(source);
//            if (result.isAvailable())
//            {
//                trueSources.add(source);
//            }
//        }
//        channel.setSources(trueSources);
//        channel.setSource(null);
//        return channel;}

    @Override
    public int removeChannel(Integer channelId) {
        return channelMapper.deleteByPrimaryKey(channelId);
    }

    @Override
    public List<Map> getAllChannel() {
        return channelMapper.selectAllChannel();
    }

    @Override
    public List<Channel> getChannelWithoutSource() {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelNew";

        List<Channel> channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, Channel.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectWithoutSource();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelList),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }

    @Override
    public List<ChannelType> getTypeList(){
        // 拼装缓存key值
        String cacheKey = SERVICE_RBK + CACHE_NAME + "channelTypeNew";

        List<ChannelType> channelType = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelType = JSON.parseArray(cacheObj, ChannelType.class);
        } else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelType = channelTypeMapper.getTypeList();
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelType),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelType;
    }

    @Override
    public List<NewChannel> selectAppChannelByKey(String key) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "app_channelByKey"+key;

        List<NewChannel> channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, NewChannel.class);
        }else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectAppChannelByKey(key);
            // 信息缓存5分钟
            cacheService.set(cacheKey, JSON.toJSONString(channelList),
                    CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }

    @Override
    public List<Integer> selectChannelByTypeId(String typeid,Integer appTypeId) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "selectChannelByKey"+typeid+appTypeId.toString();
        List<Integer> channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj, Integer.class);
        }else {
            NewChannelType newChannelType = new NewChannelType();
            // 若redis中无数据，则查询数据库, 并缓存
            //根据定位获取当前省份category
            Integer category = channelTypeMapper.getCategoryById(appTypeId);
            newChannelType.setCategory(category);
            List<Integer> channelList_1 = channelMapper.selectChannelByTypeId(newChannelType);
            if (typeid.equals("400")){
                //匹配本地则返回本地频道
                //当前本地频道为空则返回浙江频道
                if(channelList_1.isEmpty()){
                    newChannelType.setCategory(33);
                    channelList = channelMapper.selectChannelByTypeId(newChannelType);
                }else {
                    channelList = channelList_1;
                }
            }else if (typeid.equals("4000")){
                //匹配地方则先查询除本地外频道再最后加入本地频道
                newChannelType.setAppTypeId(Integer.parseInt(typeid));
                channelList = channelMapper.selectChannelByTypeId(newChannelType);
                channelList.addAll(channelList_1);
            } else {
                //匹配其他则查询对应的频道
                newChannelType.setAppTypeId(Integer.parseInt(typeid));
                channelList = channelMapper.selectChannelByTypeId(newChannelType);
            }
            if (!channelList.isEmpty())
                // 信息缓存5分钟
                cacheService.set(cacheKey, JSON.toJSONString(channelList),
                        CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }
    @Override
    public  NewChannel selectNewChannelById(Integer id){
        String cacheKey = SERVICE_RBK + CACHE_NAME + "selectNewChannelById"+id.toString();
        NewChannel channelList = null;
        // 优先从缓存中取
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseObject(cacheObj, NewChannel.class);
        }else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectNewChannelById(id);
            if (!NullUtil.isNullObject(channelList))
                // 信息缓存5分钟
                cacheService.set(cacheKey, JSON.toJSONString(channelList),
                        CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }
    @Override
    public String getTypeById(Integer id){
        String cacheKey = SERVICE_RBK + CACHE_NAME + "getTypeById"+id.toString();
        // 优先从缓存中取
        String type = null ;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            type = cacheObj;
        }else {
            // 若redis中无数据，则查询数据库, 并缓存
            type = channelTypeMapper.getTypeById(id);
            if (!NullUtil.isNullObject(type))
                // 信息缓存5分钟
                cacheService.set(cacheKey, type,
                        CacheService.CACHE_TIMEOUT);
            else{
                type = "浙江";
            }
        }
        return type;
    }

    @Override
    public List<String> selectChannelIdByKey(String key) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "selectChannelIdByKey"+key;
        // 优先从缓存中取
        List<String> channelList= null ;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channelList = JSON.parseArray(cacheObj,String.class);
        }else {
            // 若redis中无数据，则查询数据库, 并缓存
            channelList = channelMapper.selectChannelIdByKey(key);
            if (!NullUtil.isNullObject(channelList))
                // 信息缓存5分钟
                cacheService.set(cacheKey, JSON.toJSONString(channelList), CacheService.CACHE_TIMEOUT);
        }
        return channelList;
    }

    @Override
    public Channel selectChannelByChannelName(String channelName) {
        String cacheKey = SERVICE_RBK + CACHE_NAME + "selectChannelByChannelName"+channelName;
        // 优先从缓存中取
        Channel channel= null ;
        String cacheObj = cacheService.get(cacheKey);
        if (!NullUtil.isNullObject(cacheObj)) {
            channel = JSON.parseObject(cacheObj,Channel.class);
        }else {
            // 若redis中无数据，则查询数据库, 并缓存
            channel = channelMapper.selectChannelByChannelName(channelName);
            if (!NullUtil.isNullObject(channel))
                // 信息缓存5分钟
                cacheService.set(cacheKey, JSON.toJSONString(channel), CacheService.CACHE_TIMEOUT);
        }
        return channel;
    }
}