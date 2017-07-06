package com.readyidu.util;

/**
 * Created by yuzhang on 2017/6/24.
 */
public class PlayerEngineUtil {
    private static final String ENGINE_TAG = "$";

    public static String addEngine(String url, Engine engine) {
        if (!NullUtil.isNullObject(url)) {
            if (engine == Engine.ENGINE_PL) {
                return url;
            }
            return url + ENGINE_TAG + engine.toEngineTag();
        }
        return null;
    }

    public enum Engine {
        ENGINE_PL(0), ENGINE_EXO(1),ENGINE_VLC(2),ENGINE_VITAMIO(3);

        private int engineTag = 0;

        private Engine(int engineTag) {
            this.engineTag = engineTag;
        }

        public int toEngineTag() {
            return this.engineTag;
        }
    }
}
