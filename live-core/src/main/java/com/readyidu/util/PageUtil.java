package com.readyidu.util;

import com.readyidu.model.Channel;

import java.util.List;

/**
 * Created by 123 on 2017/7/21.
 */
public class PageUtil {
    private int pageNo;
    private int pageSize=20;
    private int pageCount;
    private int channelCount;
    private int pageMin;
    private int pageMax;

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    private List<Channel> channelList;
    public PageUtil(int pageNo,int channelCount){
        this.pageNo=pageNo;
        this.channelCount=channelCount;
    }
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return channelCount/pageSize+1;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getChannelCount() {
        return channelCount;
    }

    public void setChannelCount(int channelCount) {
        this.channelCount = channelCount;
    }

    public int getPageMin() {
        return (pageNo-1)*pageSize;
    }

    public void setPageMin(int pageMin) {
        this.pageMin = pageMin;
    }

    public int getPageMax() {
        return pageNo<getPageCount()?pageNo*pageSize:channelCount;
    }

    public void setPageMax(int pageMax) {
        this.pageMax = pageMax;
    }
}
