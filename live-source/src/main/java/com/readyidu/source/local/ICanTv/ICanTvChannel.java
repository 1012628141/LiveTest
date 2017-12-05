package com.readyidu.source.local.ICanTv;

import com.readyidu.source.base.Channel;
import com.readyidu.source.base.Source;
import com.readyidu.source.local.ICanTv.source.ICanTvSource;
import com.readyidu.source.local.stv.source.ICanStvSource;
import com.readyidu.source.protocol.SourceUri;
import com.readyidu.util.NullUtil;

public class ICanTvChannel extends Channel{
    public ICanTvChannel(){
        channelId = "icantv";
    }
    @Override
    public Source getSource(SourceUri uri) {
        Source source = new ICanTvSource(uri.getSource(), uri.getSourceIndex());
        if (NullUtil.isNullObject(source.toString())) {
            return null;
        }
        return source ;
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
