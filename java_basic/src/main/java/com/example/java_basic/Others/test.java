package com.example.java_basic.Others;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class test {
    public static void main(String[] args) {
//        List<String> settNos = new ArrayList<>();
//        settNos.add("1");
//        settNos.add("2");
//        System.out.println(String.join(",", settNos));

        List<TestA> list = new ArrayList<>();
        list.add(new TestA(1, 1));
        list.add(new TestA(2, 2));

        Map<Integer, TestA> map = list.stream().collect(Collectors.toMap(TestA::getId, x -> x));
        TestA t = map.get(1);
        t.setNum(3);
        for (Map.Entry<Integer, TestA> entry : map.entrySet()) {
            log.info("key: {}, value: {}", entry.getKey(), entry.getValue());
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TestA {
        private int id;
        private int num;
    }
}
