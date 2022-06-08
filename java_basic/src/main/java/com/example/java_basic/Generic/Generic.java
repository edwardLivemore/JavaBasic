package com.example.java_basic.Generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Generic<T> {
    private T key;

    public Generic(T key){
        this.key = key;
    }

    public T getKey(){
        return key;
    }

    public <E> void genericMethod(E value){
        System.out.println("generic method: " + value);
    }

    public static void main(String[] args) {
        Generic<Integer> integerGeneric = new Generic<>(123);
        System.out.println("integerGeneric class : " + integerGeneric.getClass());
        System.out.println(integerGeneric.getKey());

        Generic<String> stringGeneric = new Generic<>("abc");
        System.out.println("stringGeneric class : " + stringGeneric.getClass());
        System.out.println(stringGeneric.getKey());

        System.out.println(integerGeneric.getClass() == stringGeneric.getClass());

        integerGeneric.genericMethod("123");
        stringGeneric.genericMethod(321);

        Class clazz = integerGeneric.getClass();
        System.out.println("integerGeneric class : " + clazz.getName());

        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.println("method : " + method.toString());
        }

        // 编译报错，泛型擦除后类型为Object，无法判断是否为Integer
        // List<Integer>[] list1 = new ArrayList<Integer>[1];

        // 编译正确，因为?代表未知类型，编译器无需判断类型, 但只能读，不能写
        List<?>[] list2 = new ArrayList<?>[1];
        list2[0] = new ArrayList<Integer>();

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        System.out.println("stringList class : " + stringList.getClass());
        System.out.println("integerList class : " + integerList.getClass());
        System.out.println(stringList.getClass() == integerList.getClass());
    }
}
