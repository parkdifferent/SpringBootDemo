package com.example.demo.api;


import com.example.demo.bean.ChannelRequest;
import com.example.demo.bean.ChannelResult;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.HostType;
import com.example.demo.util.HttpUtil;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * Created by admin on 2017/6/5.
 */

@Service
public class LiveAPI {


    private static final String UTF8 = "UTF-8";

    private static final String appKey = "efabec6ca0048ba015339a824ca1ae3e";
    private static final String appSecret = "d559fd9d91ab";


    /**
     * 创建一个直播频道
     * @param name
     * @param type
     * @return
     * @throws Exception
     */
    public ChannelResult createChannel(String name, Integer type) throws Exception {
        if (name == null) {
            throw new IllegalArgumentException("Paramer 'name' is required");
        }

        if (type == null) {
            throw new IllegalArgumentException("Paramer 'type' is required");
        }


   /*     StringBuilder sb = new StringBuilder();
        sb.append("&name=").append(URLEncoder.encode(name.toString(), UTF8));
        sb.append("&type=").append(URLEncoder.encode(type.toString(), UTF8));
        String body = sb.toString();
        if (body.indexOf("&") == 0) {
            body = body.substring(1, body.length());
        }*/
        ChannelRequest channelRequest = new ChannelRequest(name,type);
        String bodyJson = channelRequest.toString();
        System.out.println(bodyJson);

        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(HostType.API, appKey, appSecret, "/app/channel/create", "application/json;charset=utf-8");
        HttpUtil.setBodyParameter(bodyJson, conn);
        //String result = HttpUtil.returnResult(conn);
        //System.out.println(result);

        return (ChannelResult) GsonUtil.fromJson(HttpUtil.returnResult(conn), ChannelResult.class);
    }

    public static void main(String[] args) {
        LiveAPI liveAPI = new LiveAPI();
        try {
            ChannelResult channelResult = liveAPI.createChannel("testChannel",Integer.valueOf(0));
            System.out.println(channelResult.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
