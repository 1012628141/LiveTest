package com.readyidu.source.base;

import com.readyidu.source.local.cctv.CCTVLocal;
import com.readyidu.source.local.fujian.FujianLocal;
import com.readyidu.source.local.guangdong.GuangdongLocal;
import com.readyidu.source.local.guangdong.dongguan.DongguanLocal;
import com.readyidu.source.local.guangdong.foshan.FoshanLocal;
import com.readyidu.source.local.guangdong.heyuan.HeyuanLocal;
import com.readyidu.source.local.guangdong.jieyang.JieyangLocal;
import com.readyidu.source.local.guangdong.meizhou.MeizhouLocal;
import com.readyidu.source.local.guangdong.qingyuan.QingyuanLocal;
import com.readyidu.source.local.guangdong.shanwei.ShanweiLocal;
import com.readyidu.source.local.guangdong.yunfu.YunfuLocal;
import com.readyidu.source.local.guangdong.zhanjiang.ZhanjiangLocal;
import com.readyidu.source.local.jiangsu.changzhou.ChangzhouLocal;
import com.readyidu.source.local.jiangsu.taizhou.TaizhouLocal;
import com.readyidu.source.local.jiangsu.yancheng.YanchengLocal;
import com.readyidu.source.local.shanghai.ShanghaiLocal;
import com.readyidu.source.local.stv.STVLocal;
import com.readyidu.source.local.zhejiang.ZhejiangLocal;
import com.readyidu.source.local.zhejiang.deqing.DeqingLocal;
import com.readyidu.source.local.zhejiang.hangzhou.HangzhouLocal;
import com.readyidu.source.local.zhejiang.ningbo.NingboLocal;
import com.readyidu.source.local.zhejiang.pinghu.PinghuLocal;
import com.readyidu.source.local.zhejiang.shangyu.ShangyuLocal;
import com.readyidu.source.local.zhejiang.shaoxing.ShaoxingLocal;
import com.readyidu.source.local.zhejiang.shengzhou.ShengzhouLocal;
import com.readyidu.source.protocol.SourceUri;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by yuzhang on 17/6/9.
 */
@Component("liveManager")
public class LiveManager {

    private HashMap<String, Local> locals;

    public LiveManager() {
        locals = new HashMap<String, Local>();
        // CCTV
        Local cctv = new CCTVLocal();
        locals.put(cctv.getId(), cctv);
        //卫视
        STVLocal stv = new STVLocal();
        locals.put(stv.getId(), stv);
        //浙江
        Local zhejiang = new ZhejiangLocal();
        locals.put(zhejiang.getId(), zhejiang);
        //杭州
        Local hangzhou = new HangzhouLocal();
        locals.put(hangzhou.getId(), hangzhou);
        //宁波
        Local ningbo = new NingboLocal();
        locals.put(ningbo.getId(), ningbo);
        //绍兴
        Local shaoxing = new ShaoxingLocal();
        locals.put(shaoxing.getId(), shaoxing);
        //上虞
        Local shangyu = new ShangyuLocal();
        locals.put(shangyu.getId(), shangyu);
        //平湖
        Local pinghu = new PinghuLocal();
        locals.put(pinghu.getId(), pinghu);
        //德清
        Local deqing = new DeqingLocal();
        locals.put(deqing.getId(), deqing);
        //嵊州
        Local shengzhou = new ShengzhouLocal();
        locals.put(shengzhou.getId(), shengzhou);

        //江苏
        //常州
        Local changzhou = new ChangzhouLocal();
        locals.put(changzhou.getId(), changzhou);
        //盐城
        YanchengLocal yancheng = new YanchengLocal();
        locals.put(yancheng.getId(), yancheng);
        //泰州
        TaizhouLocal taizhou = new TaizhouLocal();
        locals.put(taizhou.getId(), taizhou);
        //上海
        ShanghaiLocal shanghai = new ShanghaiLocal();
        locals.put(shanghai.getId(), shanghai);
        //福建
        FujianLocal fujian = new FujianLocal();
        locals.put(fujian.getId(), fujian);
        //广东
        GuangdongLocal guangdong = new GuangdongLocal();
        locals.put(guangdong.getId(), guangdong);
        //湛江
        ZhanjiangLocal zhanjiang = new ZhanjiangLocal();
        locals.put(zhanjiang.getId(), zhanjiang);
        //汕尾
        ShanweiLocal shanweiLocal = new ShanweiLocal();
        locals.put(shanweiLocal.getId(), shanweiLocal);
        //清远
        QingyuanLocal qingyuanLocal = new QingyuanLocal();
        locals.put(qingyuanLocal.getId(), qingyuanLocal);
        //揭阳
        JieyangLocal jieyangLocal = new JieyangLocal();
        locals.put(jieyangLocal.getId(), jieyangLocal);
        //梅州
        MeizhouLocal meizhouLocal = new MeizhouLocal();
        locals.put(meizhouLocal.getId(), meizhouLocal);
        //河源
        HeyuanLocal heyuanLocal = new HeyuanLocal();
        locals.put(heyuanLocal.getId(), heyuanLocal);
        //云浮
        YunfuLocal yunfuLocal = new YunfuLocal();
        locals.put(yunfuLocal.getId(), yunfuLocal);
        //东莞
        DongguanLocal dongguanLocal = new DongguanLocal();
        locals.put(dongguanLocal.getId(), dongguanLocal);
        //佛山
        FoshanLocal foshanLocal = new FoshanLocal();
        locals.put(foshanLocal.getId(), foshanLocal);
    }

    public String getChannelSource(String sourceUri) {
        if (SourceUri.isSourceUri(sourceUri)) {
            SourceUri uri = new SourceUri(sourceUri);
            Local local = locals.get(uri.getLocal());
            return local.getSource(uri).replaceAll("\r|\n", "");
        } else {
            return null;
        }
    }
}
