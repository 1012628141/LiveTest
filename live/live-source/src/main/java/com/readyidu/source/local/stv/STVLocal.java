package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.protocol.SourceUri;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/8.
 */
public class STVLocal extends Local {

    private static final String MANAGER_ID = "stv";

    public STVLocal() {
        managerId = MANAGER_ID;
        channels = new HashMap<String, Channel>();

        Channel guangdongChannel = new GuangdongStvChannel();
        Channel dongfangChannel = new DongfangStvChannel();
        Channel tianjinChannel = new TianjinStvChannel();
        Channel henanStvChannel = new HenanStvChannel();
        Channel guizhouStvChannel = new GuizhouStvChannel();
        Channel fenghuangStvChannel = new FenghuangStvChannel();
        Channel beijingChannel = new BeijingStvChannel();
        Channel chongqingStvChannel = new ChongqingStvChannel();
        Channel hunanStvChannel = new HunanStvChannel();
        Channel zhejiangStvChannel = new ZhejiangStvChannel();

        channels.put(guangdongChannel.getId(), guangdongChannel);
        channels.put(dongfangChannel.getId(), dongfangChannel);
        channels.put(tianjinChannel.getId(), tianjinChannel);
        channels.put(henanStvChannel.getId(), henanStvChannel);
        channels.put(guizhouStvChannel.getId(), guizhouStvChannel);
        channels.put(fenghuangStvChannel.getId(), fenghuangStvChannel);
        channels.put(beijingChannel.getId(), beijingChannel);
        channels.put(chongqingStvChannel.getId(), chongqingStvChannel);
        channels.put(hunanStvChannel.getId(), hunanStvChannel);
        channels.put(zhejiangStvChannel.getId(), zhejiangStvChannel);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
