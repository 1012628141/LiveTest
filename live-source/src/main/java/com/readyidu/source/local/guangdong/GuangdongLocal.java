package com.readyidu.source.local.guangdong;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.stv.GuangdongStvChannel;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class GuangdongLocal extends Local {

    private static final String MANAGER_ID = "guangdong";

    public GuangdongLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel zhujiang = new ZhujiangChannel();
        Channel tiyu = new GuangdongTiyuChannel();
        Channel gonggong = new GuangdongGonggongChannel();
        Channel xinwen = new GuangdongXinwenChannel();
        Channel guoji = new GuangdongGuojiChannel();
        Channel huizhan = new GuangdongHuizhanChannel();
        Channel fangchan = new GuangdongFangchanChannel();
        Channel tvs1 = new Tvs1Channel();
        Channel tvs2 = new Tvs2Channel();
        Channel tvs3 = new Tvs3Channel();
        Channel tvs4 = new Tvs4Channel();
        Channel tvs5 = new Tvs5Channel();

        channels.put(zhujiang.getId(), zhujiang);
        channels.put(tiyu.getId(), tiyu);
        channels.put(gonggong.getId(), gonggong);
        channels.put(xinwen.getId(), xinwen);
        channels.put(guoji.getId(), guoji);
        channels.put(huizhan.getId(), huizhan);
        channels.put(fangchan.getId(), fangchan);
        channels.put(tvs1.getId(), tvs1);
        channels.put(tvs2.getId(), tvs2);
        channels.put(tvs3.getId(), tvs3);
        channels.put(tvs4.getId(), tvs4);
        channels.put(tvs5.getId(), tvs5);

    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
