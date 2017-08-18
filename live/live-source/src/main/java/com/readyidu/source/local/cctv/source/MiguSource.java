package com.readyidu.source.local.cctv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/8/15.
 */
public class MiguSource extends Source {
    public MiguSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String miguStv = null;
        switch (sourceId){
            case SourceConstants.SOURCE_MIGU_CCTV_1:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807427");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_1:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807420");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_2:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807428");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_3:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017193");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_3:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878271");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_4:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807424");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_5:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608788132");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_5:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608788135");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_6:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608919883");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_6:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878396");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_7:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609018153");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_8:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154254");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_8:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878356");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_9:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608920109");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_9:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609006487");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_10:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608880731");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_10:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878405");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_11:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017121");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_12:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017191");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_13:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807423");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_13:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017205");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_14:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609017204");
                break;
            case SourceConstants.SOURCE_MIGU_CCTVHD_14:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878440");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_15:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608807408");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_ALB:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154345");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_FY:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609006476");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_XBY:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609006450");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_EY:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609006446");
                break;
            case SourceConstants.SOURCE_MIGU_CCTV_XKDM:
                miguStv=HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154346");
                break;
        }
        Pattern pattern = Pattern.compile("http://[a-z0-9A-Z-./_:]+.m3u8\\?[A-Za-z0-9=&_-]*");
        Matcher mather = pattern.matcher(miguStv);
        if (mather.find())
        {
            return mather.group();
        }
        return null;
    }
}
