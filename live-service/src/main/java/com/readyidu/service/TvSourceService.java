package com.readyidu.service;


import com.readyidu.model.Channel;

/**
 * Created by 123 on 2017/9/30.
 * @version 1.1.4
 */
public interface TvSourceService {
    /**
     * 搜索对应频道源
     * @param key 语音的频道识别结果
     * @return json (code: 200 成功,400 参数错误,10000 服务出错;data:{@link com.readyidu.model.Channel} 对应频道所有源)
     * @see  #selectChannelInfoByKey(String)
     */
    @Deprecated
    String selectChannelByKey(String key);
    /**
     * 获取真实源地址
     * @param sourceUri 自定义的源地址("sourceUri://**")
     * @return json (code: 200 成功,400 参数错误,10000 服务出错;data: 对应真实源地址)
     * @see #getSourceByIp(String, String)
     */
    @Deprecated
    String getSource(String sourceUri);
    /**
     * 获取真实源地址
     * @param sourceUri 自定义的源地址("sourceUri://**")
     * @param IpAdress 用户的ip
     * @return json (code: 200 成功,400 参数错误,10000 服务出错;data: 对应真实源地址)
     */
    String getSourceByIp(String sourceUri,String IpAdress);
    /**
     * 获取所有的频道源
     * @return json (code: 200 成功,10000 服务出错;data:[{@link com.readyidu.model.Channel}] 所有频道以及其对应所有源)
     * @see #getChannelList(String)
     */
    @Deprecated
    String getChannelList();
    /**
     * 获取当前频道的当前节目单，包含当天以及第二天的节目，第二天节目可能为空
     * @param channelId 当前的频道编号
     * @return json (code: 200 成功,400 参数错误,10000 服务出错;data:对应频道的节目表)
     */
    String channelPlaybill(String channelId);
    /**
     * 获取频道分类，包含分类名与分类id({"id":100,"type":"热门频道"})
     * @return json  (code: 200 成功,10000 服务出错;data:[{@link com.readyidu.model.ChannelType}] 频道分类列表)
     */
    String channelType();
    /**
     * 通过key搜索频道源，同时返回节目表
     * @param key 语音的频道识别结果
     * @return json (code: 200 成功,400 参数错误,10000 服务出错;data:{<br>
     *    channel:{@link Channel},<br>
     *    playBill:{tommorrowProgram:[{@link //com.readyidu.model.Program},<br>todayProgram: 同上]}
     * })
     */
    String selectChannelInfoByKey(String key);
    /**
     * 当源播放失效时，通过调用该方法上报
     * @param source 无法播放的源地址（）
     * @return json (code: 200 成功，400 参数错误,10000 服务出错)
     */
    String insertReport(String source);
    /**
     * 获取所有的频道源
     * @param platformName 用户使用平台
     * @return json (code: 200 成功,10000 服务出错;data:[{@link com.readyidu.model.Channel}] 所有频道以及其对应所有源)
     */
    String getChannelList(String platformName);
    /**
     * 获取直播源的播放地址
     * @param id
     * @param IpAdress 用户的ip
     * @return json(code: 200 成功,11000 无可播放地址，10000 服务出错;data：播放地址)
     */
    String getSourceById(Integer id,String IpAdress);
    /**
     * 获取点播的播放地址
     * @param id
     * @param IpAdress 用户的ip
     * @return json(code: 200 成功,11000 无可播放地址，10000 服务出错;data：播放地址)
     */
    String getDemandById(Integer id,String IpAdress);
    /**
     * 新增上报源接口
     * @param sourceId
     * @param isLive 是否是直播
     * @return json(code: 200 成功，10000服务出错)
     */
    String insertReport(Integer sourceId,Boolean isLive);

    /**
     * app端根据typeid获取频道列表以及节目表
     * @version 1.1.8
     * @param typeId  频道分类ID
     * @param id  定位的所在区域的id
     * @return json (code: 200 成功,10000 服务出错;data:[channels:{@link com.readyidu.model.NewChannel}movieList:{@link com.readyidu.model.NewDemand}] 返回所有频道以及节目表)
     */
    String getNewChannelListByTypeId(String typeId,Integer id);
    /**
     * 新增按sort排序的频道分类接口
     * @param id  定位的所在区域的id
     * @return json (code: 200 成功,10000服务出错;data:[{@link com.readyidu.model.ChannelType}] 频道分类列表,返回id，type,
     * category:客户端渲染方式0：央视、卫视、地方 无二级分类1：热播、家庭、古装剧、军旅剧、情感剧、青春剧、少儿、电影 分点播直播 2：地方台：包含各个地方)
     */
    String getTypeList(Integer id);

}