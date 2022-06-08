package com.example.java_basic.Proxy.factory;

import com.example.java_basic.Proxy.interceptor.CustomMethodInterceptor;

import org.springframework.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    
    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CustomMethodInterceptor());
        return enhancer.create();
    }
}