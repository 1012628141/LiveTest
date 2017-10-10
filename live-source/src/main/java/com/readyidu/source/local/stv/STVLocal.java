package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Local;
import com.readyidu.source.local.fujian.xiamen.XiamenLocal;
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
        Channel jiangsuStvChannel = new JiangsuStvChannel();
        Channel anhuiStvChannel = new AnhuiStvChannel();
        Channel lvyouStvChannel = new LvyouStvChannel();
        Channel guangxiStvChannel = new GuangxiStvChannel();
        Channel hubeiStvChannel = new HubeiStvChannel();
        Channel jiangxiStvChannel = new JiangxiStvChannel();
        Channel shandongStvChannel = new ShandongStvChannel();
        Channel sichuanStvChannel = new SichuanStvChannel();
        Channel shenzhenStvChannel = new ShenzhenStvChannel();
        Channel hebeiStvChannel = new HebeiStvChannel();
        Channel shanxiStvChannel = new ShanxiStvChannel();
        Channel liaoningStvChannel = new LiaoningStvChannel();
        Channel jilinStvChannel = new JilinStvChannel();
        Channel yunnanStvChannel = new YunnanStvChannel();
        Channel heilongjiangStvChannel = new HeilongjiangStvChannel();
        Channel gansuStvChannel = new GansuStvChannel();
        Channel xinjiangStvChannel = new XinjiangStvChannel();
        Channel neimengStvChannel = new NeimengStvChannel();
        Channel bintuanStvChannel = new BintuanStvChannel();
        Channel xizangStvChannel = new XizangStvChannel();
        Channel ningxiaStvChannel = new NingxiaStvChannel();
        Channel haixiaStvChannel = new HaixiaStvChannel();
        Channel dongnanStvChannel = new DongnanStvChannel();
        Channel xiamenStvChannel = new XiamenStvChannel();
        Channel miguStvChannel = new MiguStvChannel();
        Channel liangStvChannel = new LiangStvChannel();
        Channel yichengStvChannel = new YichengStvChannel();

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
        channels.put(jiangsuStvChannel.getId(), jiangsuStvChannel);
        channels.put(anhuiStvChannel.getId(), anhuiStvChannel);
        channels.put(lvyouStvChannel.getId(), lvyouStvChannel);
        channels.put(guangxiStvChannel.getId(), guangxiStvChannel);
        channels.put(hubeiStvChannel.getId(), hubeiStvChannel);
        channels.put(jiangxiStvChannel.getId(), jiangxiStvChannel);
        channels.put(shandongStvChannel.getId(), shandongStvChannel);
        channels.put(sichuanStvChannel.getId(), sichuanStvChannel);
        channels.put(shenzhenStvChannel.getId(), shenzhenStvChannel);
        channels.put(hebeiStvChannel.getId(), hebeiStvChannel);
        channels.put(shanxiStvChannel.getId(), shanxiStvChannel);
        channels.put(liaoningStvChannel.getId(), liaoningStvChannel);
        channels.put(jilinStvChannel.getId(), jilinStvChannel);
        channels.put(yunnanStvChannel.getId(), yunnanStvChannel);
        channels.put(heilongjiangStvChannel.getId(), heilongjiangStvChannel);
        channels.put(gansuStvChannel.getId(), gansuStvChannel);
        channels.put(xinjiangStvChannel.getId(), xinjiangStvChannel);
        channels.put(neimengStvChannel.getId(), neimengStvChannel);
        channels.put(bintuanStvChannel.getId(), bintuanStvChannel);
        channels.put(xizangStvChannel.getId(), xizangStvChannel);
        channels.put(ningxiaStvChannel.getId(), ningxiaStvChannel);
        channels.put(haixiaStvChannel.getId(), haixiaStvChannel);
        channels.put(dongnanStvChannel.getId(), dongnanStvChannel);
        channels.put(xiamenStvChannel.getId(), xiamenStvChannel);
        channels.put(miguStvChannel.getId(), miguStvChannel);
        channels.put(liangStvChannel.getId(), liangStvChannel);
        channels.put(yichengStvChannel.getId(), yichengStvChannel);
    }

    @Override
    public String getSource(SourceUri uri) {
        Channel channel = channels.get(uri.getChannel());
        return channel.getSource(uri).toString();
    }
}
