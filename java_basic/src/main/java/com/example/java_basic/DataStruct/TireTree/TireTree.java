package com.example.java_basic.DataStruct.TireTree;

import java.util.*;

public class TireTree {
    public Map<Character, TireTree> nodeMap = new HashMap<>();

    public void build(List<String> strings){
        for(String s : strings){
            Map<Character, TireTree> map = this.nodeMap;
            char node = '#';
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                TireTree tireTree = map.getOrDefault(node, new TireTree());
                tireTree.nodeMap.put(c, tireTree.nodeMap.getOrDefault(c, new TireTree()));
                map.put(node, tireTree);
                node = c;
                map = tireTree.nodeMap;
            }
        }
    }

    public String getPrefix(){
        StringBuilder prefix = new StringBuilder();
        TireTree tree = this.nodeMap.getOrDefault('#', null);
        while(tree != null && tree.nodeMap.size() == 1){
            for(Character key : tree.nodeMap.keySet()){
                prefix.append(key);
                tree = tree.nodeMap.get(key);
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        TireTree tree = new TireTree();
        tree.build(Arrays.asList("flat", "fleet", "flush"));
        System.out.println("common prefix : " + tree.getPrefix());
    }
}
