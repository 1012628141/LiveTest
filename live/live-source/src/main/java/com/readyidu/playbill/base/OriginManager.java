package com.readyidu.playbill.base;

import com.readyidu.playbill.analyze.TvCatParser;
import com.readyidu.playbill.analyze.YuntuParser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/9/22.
 */
@Component("originManager")
public class OriginManager {
    private Map<String,Parser> parsers;
    public OriginManager(){
        parsers = new HashMap<>();
        Parser tvCatParser = new TvCatParser();
        Parser yuntuParser = new YuntuParser();
        parsers.put(tvCatParser.getParserId(),tvCatParser);
        parsers.put(yuntuParser.getParserId(),yuntuParser);
    }
    public Map getPlaybill(String fromUrl,String origin){
        Parser parser=parsers.get(origin);
        return parser.getBill(fromUrl);
    }
}
