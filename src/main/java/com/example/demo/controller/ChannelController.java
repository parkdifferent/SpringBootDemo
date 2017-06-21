package com.example.demo.controller;

import com.example.demo.api.LiveAPI;
import com.example.demo.bean.ChannelResult;
import org.omg.CORBA.INTERNAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/6/7.
 */

@RestController
@RequestMapping("/channel")
public class ChannelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelController.class);


    @Autowired
    LiveAPI liveAPI;


    @RequestMapping(value = "create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ChannelResult> createChannel(@RequestParam("name") String name, @RequestParam("type") Integer type) {
        try {
            ChannelResult channelResult = liveAPI.createChannel(name,type);
            return ResponseEntity.ok(channelResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
