package com.example.java_basic.Proxy.sevice.impl;

import com.example.java_basic.Proxy.sevice.SmsService;

public class SmsServiceImpl implements SmsService {

    @Override
    public void SendMsg(String msg) {
        System.out.println("send msg : " + msg);
    }

}