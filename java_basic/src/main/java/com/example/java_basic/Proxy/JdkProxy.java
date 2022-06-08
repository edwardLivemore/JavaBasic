package com.example.java_basic.Proxy;

import com.example.java_basic.Proxy.factory.JdkProxyFactory;
import com.example.java_basic.Proxy.sevice.SmsService;
import com.example.java_basic.Proxy.sevice.impl.SmsServiceImpl;

public class JdkProxy {
    public static void main(String[] args) {
        SmsService service = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
        service.SendMsg("hello");
    }
}