package com.example.demo.bean;

import com.example.demo.util.GsonUtil;

/**
 * Created by admin on 2017/6/7.
 */
public class ChannelRequest {

    private String name;

    private Integer type;

    public ChannelRequest() {
    }

    public ChannelRequest(String name, Integer type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, ChannelRequest.class);
    }
}
