package com.example.java_basic.Proxy.interceptor;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CustomMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method : " + method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        System.out.println("after method : " + method.getName());
        return object;
    }

    
}
