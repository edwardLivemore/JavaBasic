package com.example.java_basic.Proxy;

import com.example.java_basic.Proxy.factory.CglibProxyFactory;
import com.example.java_basic.Proxy.sevice.AliSmsService;

public class CglibProxy {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService)CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.sendMsg("hello");
    }
}