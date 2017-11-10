package com.readyidu.source.local.stv.source;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

public class FengcaiStvSource extends Source {
    public FengcaiStvSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    protected String source() {
        String content = null ;
        String result = null ;
        switch (sourceId) {
            case SourceConstants.SOURCE_FENGCAI_STV_HN:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=179&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_ZJ:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=175&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_DF:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=266&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_GD:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=180&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_BJ:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=177&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_HLJ:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=181&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_LN:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=290&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_DN:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=163&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_JL:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=165&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_SC:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=260&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_QH:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=272&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_GS:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=284&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_JX:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=279&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_GX:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=254&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_HENAN:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=178&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_YN:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=164&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_SZ:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=244&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_TJ:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=172&timestamp=" + System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_STV_CQ:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=174&timestamp=" + System.currentTimeMillis());
                break;
//            case SourceConstants.SOURCE_FENGCAI_STV_:
//                content = HttpUtil.httpGet("" + System.currentTimeMillis());
//                break;

        }
        if (!NullUtil.isNullObject(content))
        {
            JSONObject jsonObj = JSONObject.parseObject(content);
            JSONArray urls = jsonObj.getJSONObject("data").getJSONArray("play_urls").getJSONObject(0).getJSONArray("urls");
            String url = urls.getString(index);
            Boolean needChange = url.contains("\\u0026");
            if (needChange){
                result = url.replace("\\u0026","&");
            }else {
                result = url ;
            }
        }
        return result;
    }
}
