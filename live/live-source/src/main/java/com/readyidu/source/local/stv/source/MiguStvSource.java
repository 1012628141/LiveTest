package com.readyidu.source.local.stv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BNDYH on 2017/8/16.
 */
public class MiguStvSource extends Source {
    public MiguStvSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String carouselSource = null;
        switch (sourceId){
            case SourceConstants.SOURCE_MIGU_STV_BJWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154074");
                break;
            case SourceConstants.SOURCE_MIGU_STV_JSWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623899368");
                break;
            case SourceConstants.SOURCE_MIGU_STV_DFWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=619811679");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SDWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=619618278");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SSWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624303319");
                break;
            case SourceConstants.SOURCE_MIGU_STV_AHWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878947");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HLJWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624303427");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HBWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878953");
                break;
            case SourceConstants.SOURCE_MIGU_STV_LNWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624878951");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GDWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608831231");
                break;
            case SourceConstants.SOURCE_MIGU_STV_TJWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=627065430");
                break;
            case SourceConstants.SOURCE_MIGU_STV_JSWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623899540");
                break;
            case SourceConstants.SOURCE_MIGU_STV_DFWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608790604");
                break;
            case SourceConstants.SOURCE_MIGU_STV_BJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=615912578");
                break;
            case SourceConstants.SOURCE_MIGU_STV_AHWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608780629");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HNWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609153594");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HUNWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609153595");
                break;
            case SourceConstants.SOURCE_MIGU_STV_ZJWSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623539769");
                break;
            case SourceConstants.SOURCE_MIGU_STV_ZJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=622992650");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GDWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608831538");
                break;
            case SourceConstants.SOURCE_MIGU_STV_NFWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608917627");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SSWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624303317");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SDJY:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154353");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SDWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=619618199");
                break;
            case SourceConstants.SOURCE_MIGU_STV_LNWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623583504");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SCWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608880878");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779358");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HENWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779360");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GZWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779450");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HLJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779861");
                break;
            case SourceConstants.SOURCE_MIGU_STV_DNWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609153805");
                break;
            case SourceConstants.SOURCE_MIGU_STV_TJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=627065515");
                break;
            case SourceConstants.SOURCE_MIGU_STV_GSWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608907550");
                break;
            case SourceConstants.SOURCE_MIGU_STV_XZWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608907682");
                break;
            case SourceConstants.SOURCE_MIGU_STV_BTWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608914624");
                break;
            case SourceConstants.SOURCE_MIGU_STV_CQWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609024130");
                break;
            case SourceConstants.SOURCE_MIGU_STV_JXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608924994");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HEBWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609026126");
                break;
            case SourceConstants.SOURCE_MIGU_STV_JLWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609020981");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SHANXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609022770");
                break;
            case SourceConstants.SOURCE_MIGU_STV_XMWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608935834");
                break;
            case SourceConstants.SOURCE_MIGU_STV_YNWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154293");
                break;
            case SourceConstants.SOURCE_MIGU_STV_NMGWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608914971");
                break;
            case SourceConstants.SOURCE_MIGU_STV_NXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608914867");
                break;
            case SourceConstants.SOURCE_MIGU_STV_XJWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608779373");
                break;
            case SourceConstants.SOURCE_MIGU_STV_QHWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=608915204");
                break;
            case SourceConstants.SOURCE_MIGU_STV_SXWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=609154295");
                break;
            case SourceConstants.SOURCE_MIGU_STV_HUBWS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=615945699");
                break;
        }
        Pattern pattern = Pattern.compile("http://[a-z0-9A-Z-./_:]+.m3u8\\?[A-Za-z0-9=&_-]*");
        Matcher mather = pattern.matcher(carouselSource);
        if (mather.find())
        {
            return mather.group();
        }
        return null;
    }
}
