package com.readyidu.source.base;

import com.readyidu.util.NullUtil;

/**
 * Created by yuzhang on 17/6/8.
 */
abstract public class Source {

    protected String sourceId;
    protected String source;
    protected int index;

    public Source(String sourceId) {
        this.sourceId = sourceId;
    }

    public Source(String sourceId, int index) {
        this.sourceId = sourceId;
        this.index = index;
    }

    abstract protected String source();

    @Override
    public String toString() {
        String source = source();
        if (NullUtil.isNullObject(source)) {
            return this.source;
        }
        this.source = source;
        return source;
    }
}
