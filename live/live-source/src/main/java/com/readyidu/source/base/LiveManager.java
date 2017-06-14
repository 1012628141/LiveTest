package com.readyidu.source.base;

import com.readyidu.source.local.zhejiang.hangzhou.HangzhouLocal;
import com.readyidu.source.local.zhejiang.ningbo.NingboLocal;
import com.readyidu.source.local.zhejiang.shaoxing.ShaoxingLocal;
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
        //杭州
        Local hangzhou = new HangzhouLocal();
        locals.put(hangzhou.getId(), hangzhou);
        //宁波
        Local ningbo = new NingboLocal();
        locals.put(ningbo.getId(), ningbo);
        //绍兴
        Local shaoxing = new ShaoxingLocal();
        locals.put(shaoxing.getId(), shaoxing);
    }

    public String getChannelSource(String sourceUri) {
        if (SourceUri.isSourceUri(sourceUri)) {
            SourceUri uri = new SourceUri(sourceUri);
            Local local = locals.get(uri.getLocal());
            return local.getSource(uri);
        } else {
            return null;
        }
    }
}
