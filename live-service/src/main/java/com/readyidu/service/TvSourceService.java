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
     * @see
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

    String getChannelList(String platformName);
}