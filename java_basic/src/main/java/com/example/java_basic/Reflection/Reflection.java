package com.example.java_basic.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = Class.forName("com.example.java_basic.Reflection.TargetObject");
        TargetObject targetObject = (TargetObject) clazz.newInstance();
        
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }

        Method publicMethod = clazz.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "pulbic method is running");

        targetObject.value();
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject, "changed value");
        targetObject.value();

        Method privateMethod = clazz.getDeclaredMethod("privateMethod", String.class);
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject, "private method is running");
    }
}