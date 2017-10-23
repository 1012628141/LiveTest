package com.readyidu.pojo;

import com.readyidu.util.NullUtil;

/**
 * Created by 123 on 2017/10/18.
 */
public class Pixel {
    private int height;
    private int width;
    public Pixel(String str) {
        if (!NullUtil.isNullObject(str))
        {
            String[] values = str.split("x");
            this.width = Integer.valueOf(values[0]);
            this.height = Integer.valueOf(values[1]);
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
