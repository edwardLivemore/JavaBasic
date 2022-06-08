package com.example.java_basic.Algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class TopN {
    public static <T> List<T> getTopN(Node<T> node, int n){
        List<T> result = new ArrayList<>();
        if(n == 0) return result;

        Map<T, Integer> map = new HashMap<>();

        while (node != null){
            int count = map.getOrDefault(node.val, 0);
            map.put(node.val, count + 1);
            node = node.next;
        }

        // 方法一 利用TreeSet
//        Set<Map.Entry<T, Integer>> set = new TreeSet<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
//        set.addAll(map.entrySet());
//        int i = 0;
//        for(Map.Entry<T, Integer> e : set){
//            if(i++ == n){
//                break;
//            }
//            result.add(e.getKey());
//        }

        // 方法二 利用优先队列
        PriorityQueue<Map.Entry<T, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<T, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if(queue.size() == n){
                if(queue.peek().getValue() < value){
                    queue.poll();
                    queue.offer(entry);
                }
            }else{
                queue.offer(entry);
            }
        }

        while(!queue.isEmpty()){
            result.add(queue.poll().getKey());
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        int num = 5;
        Map<Integer, List<Node<Integer>>> nodeMap = new HashMap<>();
        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= i; j++){
                List<Node<Integer>> list = nodeMap.getOrDefault(i, new ArrayList<>());
                list.add(new Node<>(i));
                nodeMap.put(i, list);
            }
        }

        List<Node<Integer>> nodes = nodeMap.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        for(int i = 0; i < nodes.size() - 1; i++){
            nodes.get(i).next = nodes.get(i + 1);
        }

        List<Integer> list = TopN.getTopN(nodes.get(0), 3);
        list.forEach(System.out::println);
    }
}

class Node<T> {
    T val;
    Node<T> next;

    public Node(T val){
        this.val = val;
    }
}

