package com.readyidu.source.local.cctv.source;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readyidu.source.base.Source;
import com.readyidu.source.protocol.SourceConstants;
import com.readyidu.util.HttpUtil;
import com.readyidu.util.NullUtil;

public class CCTVFengcaiSource extends Source {
    public CCTVFengcaiSource(String sourceId, int index) {
        super(sourceId, index);
    }

    @Override
    public String getSource() {
        return super.getSource();
    }

    @Override
    protected String source() { 
        String content = null ;
        String result = null ;
        switch (sourceId){
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV1:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=160&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV2:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=315&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV3:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=329&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV4:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=162&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV5:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=264&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV6:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=307&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV7:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=330&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV8:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=261&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV9:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=299&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV10:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=251&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV11:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=292&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV12:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=263&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV13:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=274&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV14:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=161&timestamp="+System.currentTimeMillis());
                break;
            case SourceConstants.SOURCE_FENGCAI_CCTV_CCTV15:
                content = HttpUtil.httpGet("http://apiv1.starschina.com/cms/v1.0/stream?app_key=xdThhy2239daax&app_version=7.4.11&installation_id=1709271813429910&os_type=1&sign=&id=333&timestamp="+System.currentTimeMillis());
                break;
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
