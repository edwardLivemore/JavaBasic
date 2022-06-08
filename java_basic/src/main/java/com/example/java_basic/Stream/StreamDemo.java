package com.example.java_basic.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        // flatmapTest();
        streamMapTest();
    }

    private static void flatmapTest() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("1", Arrays.asList("a","b"));
        map.put("2", Arrays.asList("b","c","d"));
        // List<String> list = map.values().stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
        List<String> list = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    private static void streamMapTest() {
        Map<String, Long> map = new HashMap<>();
        map.put("1", 10L);
        map.put("2", 20L);
        
        Map<String, Float> result = new HashMap<>();
        for(String key : map.keySet()) {
            Long value = map.get(key);
            Float newValue = Float.parseFloat(value.toString()) / 30;
            result.put(key, newValue);
        }
        result.values().forEach(System.out::println);
    }
}