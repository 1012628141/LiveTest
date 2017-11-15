package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.FengcaiStvSource;
import com.readyidu.source.local.stv.source.FengmiStvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

public class FengcaiStvChannel extends Channel {

    public FengcaiStvChannel(){
        channelId = "stv_fengcai";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source= new FengcaiStvSource(uri.getSource(),uri.getSourceIndex());
        if(NullUtil.isNullObject(source.toString())){
            return null ;
        }
        return source ;
    }
}
