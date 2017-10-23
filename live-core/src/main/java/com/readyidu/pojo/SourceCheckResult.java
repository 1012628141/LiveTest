package com.readyidu.pojo;

/**
 * Created by 123 on 2017/10/18.
 */
public class SourceCheckResult {
    private boolean isAvailable; //视频是否可播放
    private Pixel pixel; //视频像素

    public SourceCheckResult(boolean isAvailable, String pixel) {
        this.isAvailable = isAvailable;
        this.pixel = new Pixel(pixel);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Pixel getPixel() {
        return pixel;
    }

    public void setPixel(Pixel pixel) {
        this.pixel = pixel;
    }
}
