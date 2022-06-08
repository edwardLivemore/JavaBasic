package com.example.java_basic.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class Hashdemo {
    private Integer name;

    public Hashdemo(Integer name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public static void main(String[] args) {
        Map<Hashdemo, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Hashdemo hashdemo = new Hashdemo(i);
            map.put(hashdemo, i);
        }
    }
}
