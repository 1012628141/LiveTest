package com.readyidu.source.base;

import com.readyidu.source.local.carousel.CarouselLocal;
import com.readyidu.source.local.anhui.AnhuiLocal;
import com.readyidu.source.local.cctv.CCTVLocal;
import com.readyidu.source.local.chongqing.ChongqinLocal;
import com.readyidu.source.local.fujian.FujianLocal;
import com.readyidu.source.local.fujian.xiamen.XiamenLocal;
import com.readyidu.source.local.guangdong.GuangdongLocal;
import com.readyidu.source.local.guangdong.dongguan.DongguanLocal;
import com.readyidu.source.local.guangdong.foshan.FoshanLocal;
import com.readyidu.source.local.guangdong.heyuan.HeyuanLocal;
import com.readyidu.source.local.guangdong.jiangmen.JiangmenLocal;
import com.readyidu.source.local.guangdong.jieyang.JieyangLocal;
import com.readyidu.source.local.guangdong.meizhou.MeizhouLocal;
import com.readyidu.source.local.guangdong.qingyuan.QingyuanLocal;
import com.readyidu.source.local.guangdong.shanwei.ShanweiLocal;
import com.readyidu.source.local.guangdong.yunfu.YunfuLocal;
import com.readyidu.source.local.guangdong.zhanjiang.ZhanjiangLocal;
import com.readyidu.source.local.guangdong.zhaoqing.ZhaoqingLocal;
import com.readyidu.source.local.heilongjiang.haerbin.HaerbinLocal;
import com.readyidu.source.local.henan.HenanLocal;
import com.readyidu.source.local.hubei.jingmen.JingmenLocal;
import com.readyidu.source.local.hubei.wuhan.WuhanLocal;
import com.readyidu.source.local.hubei.yichang.YichangLocal;
import com.readyidu.source.local.hunan.hunan.HunanLocal;
import com.readyidu.source.local.hunan.zhuzhou.ZhuzhouLocal;
import com.readyidu.source.local.jiangsu.changzhou.ChangzhouLocal;
import com.readyidu.source.local.jiangsu.huaian.HuaianLocal;
import com.readyidu.source.local.jiangsu.jiangsu.JiangsuLocal;
import com.readyidu.source.local.jiangsu.taizhou.TaizhouLocal;
import com.readyidu.source.local.jiangsu.yancheng.YanchengLocal;
import com.readyidu.source.local.jiangxi.JiangxiLocal;
import com.readyidu.source.local.jiangxi.jian.JianLocal;
import com.readyidu.source.local.jiangxi.shangrao.ShangraoLocal;
import com.readyidu.source.local.shan3xi.weinan.WeinanLocal;
import com.readyidu.source.local.jilin.jilin.JilinLocal;
import com.readyidu.source.local.shandong.jinan.JinanLocal;
import com.readyidu.source.local.shandong.rizhao.RizhaoLocal;
import com.readyidu.source.local.shandong.shandong.ShandongLocal;
import com.readyidu.source.local.shanghai.ShanghaiLocal;
import com.readyidu.source.local.sichuan.chengdu.ChengduLocal;
import com.readyidu.source.local.sichuan.lvzhou.LuzhouLocal;
import com.readyidu.source.local.sichuan.mianyang.MianyangLocal;
import com.readyidu.source.local.sichuan.shuangliu.ShuangliuLocal;
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
        // CNTV
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
        //淮安
        HuaianLocal huaianLocal = new HuaianLocal();
        locals.put(huaianLocal.getId(), huaianLocal);
        //常州
        Local changzhou = new ChangzhouLocal();
        locals.put(changzhou.getId(), changzhou);
        //盐城
        YanchengLocal yancheng = new YanchengLocal();
        locals.put(yancheng.getId(), yancheng);
        //泰州
        TaizhouLocal taizhou = new TaizhouLocal();
        locals.put(taizhou.getId(), taizhou);
        //江苏省台
        JiangsuLocal jiangsuLocal = new JiangsuLocal();
        locals.put(jiangsuLocal.getId(),jiangsuLocal);

        //上海
        ShanghaiLocal shanghai = new ShanghaiLocal();
        locals.put(shanghai.getId(), shanghai);

        //福建
        FujianLocal fujian = new FujianLocal();
        locals.put(fujian.getId(), fujian);
        //厦门
        XiamenLocal xiamenLocal = new XiamenLocal();
        locals.put(xiamenLocal.getId(), xiamenLocal);

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
        //肇庆
        ZhaoqingLocal zhaoqingLocal = new ZhaoqingLocal();
        locals.put(zhaoqingLocal.getId(), zhaoqingLocal);
        //江门
        JiangmenLocal jiangmenLocal = new JiangmenLocal();
        locals.put(jiangmenLocal.getId(), jiangmenLocal);


        //重庆
        ChongqinLocal chongqinLocal = new ChongqinLocal();
        locals.put(chongqinLocal.getId(), chongqinLocal);

        //湖南
        HunanLocal hunanLocal = new HunanLocal();
        locals.put(hunanLocal.getId(), hunanLocal);
        //株洲
        ZhuzhouLocal zhuzhouLocal = new ZhuzhouLocal();
        locals.put(zhuzhouLocal.getId(), zhuzhouLocal);

        //江西
        JiangxiLocal jiangxiLocal = new JiangxiLocal();
        locals.put(jiangxiLocal.getId(), jiangxiLocal);
        //上饶
        ShangraoLocal shangraoLocal = new ShangraoLocal();
        locals.put(shangraoLocal.getId(), shangraoLocal);
        //吉安
        JianLocal jianLocal = new JianLocal();
        locals.put(jianLocal.getId(), jianLocal);

        //河南
        HenanLocal henanLocal = new HenanLocal();
        locals.put(henanLocal.getId(), henanLocal);
        //安徽
        AnhuiLocal anhuiLocal=new AnhuiLocal();
        locals.put(anhuiLocal.getId(),anhuiLocal);

        //四川
        //成都
        ChengduLocal chengduLocal = new ChengduLocal();
        locals.put(chengduLocal.getId(), chengduLocal);
        //双流
        ShuangliuLocal shuangliuLocal = new ShuangliuLocal();
        locals.put(shuangliuLocal.getId(), shuangliuLocal);
        //绵阳
        MianyangLocal mianyangLocal = new MianyangLocal();
        locals.put(mianyangLocal.getId(), mianyangLocal);
        //泸州
        LuzhouLocal luzhouLocal = new LuzhouLocal();
        locals.put(luzhouLocal.getId(), luzhouLocal);

        //湖北
        //武汉
        WuhanLocal wuhanLocal = new WuhanLocal();
        locals.put(wuhanLocal.getId(),wuhanLocal);
        //荆门
        JingmenLocal jingmenLocal = new JingmenLocal();
        locals.put(jingmenLocal.getId(),jingmenLocal);
        //宜昌
        YichangLocal yichangLocal = new YichangLocal();
        locals.put(yichangLocal.getId(),yichangLocal);

        //黑龙江
        //哈尔滨
        HaerbinLocal haerbinLocal = new HaerbinLocal();
        locals.put(haerbinLocal.getId(),haerbinLocal);

        //山东
        //济南
        JinanLocal jinanLocal = new JinanLocal();
        locals.put(jinanLocal.getId(),jinanLocal);
        //日照
        RizhaoLocal rizhaoLocal = new RizhaoLocal();
        locals.put(rizhaoLocal.getId(),rizhaoLocal);
        //山东省台
        ShandongLocal shandongLocal = new ShandongLocal();
        locals.put(shandongLocal.getId(),shandongLocal);

        //吉林
        JilinLocal jilinLocal = new JilinLocal();
        locals.put(jilinLocal.getId(),jilinLocal);


        //陕西
        //渭南
        WeinanLocal weinanLocal = new WeinanLocal();
        locals.put(weinanLocal.getId(),weinanLocal);

        //轮播
        CarouselLocal carouselLocal =new CarouselLocal();
        locals.put(carouselLocal.getId(),carouselLocal);

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
