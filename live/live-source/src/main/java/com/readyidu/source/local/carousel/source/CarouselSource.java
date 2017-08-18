package com.readyidu.source.local.carousel.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BNDYH on 2017/8/16.
 */
public class CarouselSource extends Source {
    public CarouselSource(String sourceId) {
        super(sourceId);
    }

    @Override
    protected String source() {
        String carouselSource = null;
        switch (sourceId){
            case SourceConstants.SOURCE_MIGU_CAROUSEL_SJJC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=629068516");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_DQRJBUT:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625155140");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_SDMZJC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625498431");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JLJC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625643517");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_HZSBQ:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625520490");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_RYJC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625827063");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_DMFFL:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625525181");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_TLBBJ:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625703337");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_PAXC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=627033503");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LTZPJ:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625514969");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JYPD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625774640");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LMBQT:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625521420");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_KTB:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625574493");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_SDJC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625681367");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_ZJSN:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=617432318");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_ZJYS:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=626157526");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JKZG:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=626168301");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JDFYT:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=626157538");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_KATVB:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623338112");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_TSYZPJ:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625966779");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_DKZXC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=626157575");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LSSZPJ:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625759619");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_MGFYT:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=619495952");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_MGYSHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=617432495");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LDJ:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625681368");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_XAJH:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625759558");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_DFDYHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=623674834");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_LIVESHOWHD:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=617432328");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_JPGCJ:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625574378");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_HSHBJP:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=624999147");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_NDJC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625774631");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_XXGJC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=625526423");
                break;
            case SourceConstants.SOURCE_MIGU_CAROUSEL_ZYXC:
                carouselSource= HttpUtil.httpGet("http://m.miguvideo.com/wap/resource/migu/detail/Detail_live.jsp?cid=621640581");
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
