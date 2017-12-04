package com.readyidu.source.local.stv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.stv.source.FengcaiStvSource;
import com.readyidu.source.local.stv.source.ICanStvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

public class ICanStvChannel extends Channel {
    public ICanStvChannel(){
        channelId = "stv_ican";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source= new ICanStvSource(uri.getSource(),uri.getSourceIndex());
        if(NullUtil.isNullObject(source.toString())){
            return null ;
        }
        return source ;
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
