package com.example.java_basic.Param;

public class ValueDemo {
    public static void main(String[] args) {
        stringTest();

        numTest();

        intTest();
    }

    private static void intTest() {
        int i = 0;
        System.out.println(i++ + addone(i));
        System.out.println(i);

    }

    private static int addone(int i) {
        System.out.println("add one : " + i++);
        return i;
    }

    private static void stringTest() {
        System.out.println("======= string test ========");

        String str = "ab";
        System.out.println("str == test(str) : " + (str == test(str)));
        System.out.println("main: " + str);

        String a = "test";
        String b = "test";
        System.out.println("main: a == b : " + (a == b));

        String c = "abc";
        String d = new String("abc");
        System.out.println("c == d : " + (c == d));     // false c为常量池中的"abc", d为堆里的对象s4,指向常量池中的"abc"

        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hel"+ "lo";
        String s4 = "hel" + new String("lo");
        String s5 = new String("hello");
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8;
        System.out.println("s1 == s2 : " + (s1 == s2));     // true
        System.out.println("s1 == s3 : " + (s1 == s3));     // true 编译期已确定,编译器优化
        System.out.println("s1 == s4 : " + (s1 == s4));     // false 运行期才能确定s4的地址
        System.out.println("s1 == s9 : " + (s1 == s9));     // false s7与s8无法预料, 对比 s1 == s3
        System.out.println("s4 == s5 : " + (s4 == s5));     // false
        System.out.println("s1 == s6 : " + (s1 == s6));     // true 归功于intern方法,先去常量池寻找

        System.out.println("======= string test ========");
        System.out.println();
    }

    private static void numTest() {
        System.out.println("======= num test ========");
        int i1 = 10;
        double d1 = 10.0D;
        Integer i2 = 10;
        Integer i3 = 128;
        Integer i4 = i2;
        Integer i5 = new Integer(10);
        Integer i6 = new Integer(10);
        double d2 = 128.0D;
        Double d3 = new Double(128.0D);

        System.out.println("i1 == d1 : " + (i1 == d1));
        System.out.println("10 == 10.00 : " + (10 == 10.00));
        System.out.println("i2 == d1 : " + (i2 == d1));
        System.out.println("i1 == i2 : " + (i1 == i2));
        System.out.println("i1 == i3 : " + (i1 == i3));
        System.out.println("i1 == i4 : " + (i1 == i4));
        System.out.println("i5 == i6 : " + (i5 == i6));
        System.out.println("i1 == i5 : " + (i1 == i5));
        System.out.println("i3 == d2 : " + (i3 == d2));
        System.out.println("d2 == d3 : " + (d2 == d3));
//        System.out.println("i3 == d3 : " + (i3 == d3)); 编译失败
        System.out.println("======= num test ========");
        System.out.println();
    }

    private static String test(String str) {
        str = "cd";
        System.out.println("test: " + str);
        return str;
    }
}
