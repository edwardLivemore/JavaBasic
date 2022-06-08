package com.example.java_basic.Algorithm;

public class LinkNode<T> {
    T val;
    LinkNode<T> next;

    public LinkNode(T val){
        this.val = val;
    }

    public static void main(String[] args) {
        LinkNode<Integer> node1 = new LinkNode<>(1);
        LinkNode<Integer> node2 = new LinkNode<>(2);
        LinkNode<Integer> node3 = new LinkNode<>(3);
        node1.next = node2;
        node2.next = node3;
        // 递归倒序输出
        LinkNodeHelper.reverseRecursion(node1);
        // 原地反转输出
        LinkNodeHelper.reverseReplace(node1);
    }
}

class LinkNodeHelper{
    // 递归
    public static <T> void reverseRecursion(LinkNode<T> node){
        if(node != null) {
            if(node.next != null){
                reverseRecursion(node.next);
            }
            System.out.println(node.val);
        }
    }

    public static <T> void reverseReplace(LinkNode<T> node){
        LinkNode<T> header = reverse(node);
        while (header.next != null){
            System.out.println(header.next.val);
            header = header.next;
        }
    }

    // 原地反转
    private static <T> LinkNode<T> reverse(LinkNode<T> node){
        LinkNode<T> header = new LinkNode<>(null);
        if(node == null){
            return null;
        }
        header.next = node;

        while(node.next != null){
            LinkNode<T> first = node;
            LinkNode<T> second = first.next;
            first.next = second.next;
            second.next = header.next;
            header.next = second;
            node = first;
        }

        return header;
    }
}
