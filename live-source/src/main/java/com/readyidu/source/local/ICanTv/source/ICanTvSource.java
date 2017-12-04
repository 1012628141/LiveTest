package com.readyidu.source.local.ICanTv.source;

import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICanTvSource extends Source {
    public ICanTvSource(String sourceId, int index) {
        super(sourceId, index);
    }
    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        switch (sourceId) {
            case SourceConstants.SOURCE_ICAN_GD_GDZJ:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=gdzj");
                break;
            case SourceConstants.SOURCE_ICAN_GD_GDTY:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=gdty");
                break;
            case SourceConstants.SOURCE_ICAN_GD_GDGG:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=gdgg");
                break;
            case SourceConstants.SOURCE_ICAN_GD_GDXW:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=gdxw");
                break;
            case SourceConstants.SOURCE_ICAN_GD_GDGJ:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=gdgj");
                break;
            case SourceConstants.SOURCE_ICAN_GD_NFJJ:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=tvs1");
                break;
            case SourceConstants.SOURCE_ICAN_GD_NFZY:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=tvs3");
                break;
            case SourceConstants.SOURCE_ICAN_GD_NFYS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=tvs4");
                break;
            case SourceConstants.SOURCE_ICAN_GD_JJKT:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=jjkt");
                break;
            case SourceConstants.SOURCE_ICAN_GD_GDFC:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=gdfc");
                break;
            case SourceConstants.SOURCE_ICAN_GD_NFGW:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=nfgw");
                break;
            case SourceConstants.SOURCE_ICAN_GD_GDSE:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=gdse");
                break;
            case SourceConstants.SOURCE_ICAN_GD_FSZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=fszh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_DGZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=dgzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_HZZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=hzzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_CZZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=czzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_STZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=stzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_JYZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=jyzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_QYZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=qyzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_MZZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=mzzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_ZSZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=zszh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_ZJZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=zjzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_MMZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=mmzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_JMZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=jmzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_ZHZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=zhzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_ZQZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=zqzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_YJZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=yjzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_SGZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=sgzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_HYZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=hyzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_SWZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=swzh");
                break;
            case SourceConstants.SOURCE_ICAN_GD_YFZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=yfzh");
                break;
            case SourceConstants.SOURCE_ICAN_SH_XWZH:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/grtn.php?id=yfzh");
                break;
            case SourceConstants.SOURCE_ICAN_HLJ_HLJWT:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/hljtv.php?id=hljwt");
                break;
            case SourceConstants.SOURCE_ICAN_HLJ_HLJYS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/hljtv.php?id=hljys");
                break;
            case SourceConstants.SOURCE_ICAN_HLJ_HLJXW:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/hljtv.php?id=hljxw");
                break;
            case SourceConstants.SOURCE_ICAN_HLJ_HLJDS:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/hljtv.php?id=hljds");
                break;
            case SourceConstants.SOURCE_ICAN_HLJ_HLJNY:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/hljtv.php?id=hljny");
                break;
            case SourceConstants.SOURCE_ICAN_HLJ_HLJSE:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/hljtv.php?id=hljse");
                break;
            case SourceConstants.SOURCE_ICAN_HLJ_HLJNK:
                content = HttpUtil.httpGet("http://www.icantv.cn/plus/hljtv.php?id=hljnk");
                break;

        }
        if(!NullUtil.isNullObject(content)){
            String regex1 = "a: 'http:([\\s\\S]*?).m3u8[?]+([\\s\\S]*?)'";
            String regex2 = "f:'rtmp:([\\s\\S]*?)'";
            String regex3 = "f:'http:([\\s\\S]*?).flv[?]?([\\s\\S]*?)'";
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher = pattern1.matcher(content);
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(content);
            Pattern pattern3 = Pattern.compile(regex3);
            Matcher matcher3 = pattern3.matcher(content);

            if (matcher.find()){
                result = matcher.group().replace("a: '","").replace("\"","");
            }else if(matcher2.find()){
                result = matcher2.group().replace("f:'","").replace("\"","");
            }else if (matcher3.find()){
                result = matcher2.group().replace("f:'","").replace("\"","");
            }else {
                return null;
            }
        }
        return result ;
    }

    @Override
    public String getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
