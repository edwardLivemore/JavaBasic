package com.example.java_basic.Param;

public class StringDemo {
    static void swap(String text){
        String s = text.replace("j", "l");
        System.out.println("swap method text: " + s);
    }

    public static void main(String[] args) {
        String text = new String("java");
        swap(text);
        System.out.println("main method text: " + text);
        
        // for(int i = 0; i < 10; i++){
        //     for(int j = 0; j < 5; j++){
        //         if(j == 3){
        //             break;
        //         }
        //         System.out.println("i = " + i + ", j = " + j);
        //     }
        // }

    }
    
}
