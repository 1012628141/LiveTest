package com.readyidu.source.local.carousel.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;
import org.apache.http.util.TextUtils;

/**
 * Created by 123 on 2017/8/10.
 */
public class LeSource extends Source{
    public LeSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        if (TextUtils.isEmpty(sourceId))
        {
            return null;
        }
        String leCarousel=null;
        switch (sourceId){
            case SourceConstants.SOURCE_LOL_CAROUSEL:
                leCarousel = HttpUtil.httpGet("http://live.g3proxy.lecloud.com/gslb?stream_id=lb_dzjj_800&tag=live&ext=m3u8&format=1&expect=2&termid=1&hwtype=un&platid=10&playid=1&sign=live_web&splatid=1001&ostype=Mac%20OS%2010.12.0&p1=1&p2=14&p3=-&uuid=27810AC87D6C4A357DE9E0F1B65786290351471E_0&vkit=20170511&station=547&tm=1502349396514");
                break;
        }
        if (!NullUtil.isNullObject(leCarousel)){
            JSONObject leJson=null;
            try {
                leJson = JSON.parseObject(leCarousel);
            }catch (Exception e){
                System.out.println(e);
            }
            if (!NullUtil.isNullObject(leJson)){
                String node=null;
                JSONArray nodeJson=null;
                switch (index){
                    case 1:
                        return leJson.getString("location");
                    case 2:
                        node = leJson.getString("nodelist");
                        nodeJson = JSON.parseArray(node);
                        return nodeJson.getJSONObject(0).getString("location");
                    case 3:
                        node = leJson.getString("nodelist");
                        nodeJson = JSON.parseArray(node);
                        return nodeJson.getJSONObject(1).getString("location");
                }
            }
        }
        return null;
    }
}
