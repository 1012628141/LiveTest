package com.readyidu.service;


import com.readyidu.model.Channel;
import com.readyidu.model.NewChannel;

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
     * app端获取所有频道列表
     * @return json (code: 200 成功,10000 服务出错;data:[{@link com.readyidu.model.NewChannelChannel}] 返回所有频道和分类ID)
     */
    String getNewChannelList();

    /**
     * app端通过节目类型ID（typeId）查询节目单列表
     * @param typeId 节目类型ID
     * @return json (code: 200 成功,10000 服务出错; 返回同个节目类型下所有的频道节目表（2天）)
     */
    String getchannelPlaybillByTypeId(String typeId);
    /**
     * 新增按sort排序的频道分类接口
     * @return json(code:200成功,10000服务出错;data:[{@link com.readyidu.model.ChannelType}] 频道分类列表,返回id，type)
     */
    String getTpyeList();

    /**
     * 新增按频道id获取频道源接口,返回源地址，源清晰度，源响应时间
     * @param channelId
     * @param ipAdress
     * @return json(code: 200 成功,11000 无可播放地址，10000 服务出错;data：[{@link com.readyidu.model.NewChannelSource}]data包括源播放地址，源清晰度，源响应时间，是否是自己源)
     */
    String getSourceByIdNew(Integer channelId,String ipAdress);

    /**
     * 新增获取天翼点播源接口，通过id查询对应源地址
     * @param id
     * @return json(code: 200 成功，10000 服务出错;data:source 源的播放地址)
     */
    String getDemandByIdNew(Integer id);
}