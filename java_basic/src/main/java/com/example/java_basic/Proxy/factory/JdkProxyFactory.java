package com.example.java_basic.Proxy.factory;

import java.lang.reflect.Proxy;

import com.example.java_basic.Proxy.handler.CustomInvocationHandler;

public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
                target.getClass().getInterfaces(), 
                new CustomInvocationHandler(target));
    }
}
