package com.readyidu.source.local.stv.source;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuzhang on 2017/6/21.
 */
public class StvSource extends Source {

    public StvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        switch (sourceId) {
            case SourceConstants.SOURCE_STV_STV:
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(new Date());
            String stvStv = HttpUtil.httpGet("http://m.kankanews.com/web/fakeESI?module=catchUP&info=081_" + date);
            JSONObject stvObject = JSON.parseObject(stvStv);
            return stvObject.getString("live");
            default:
                return null;
        }
    }
}
