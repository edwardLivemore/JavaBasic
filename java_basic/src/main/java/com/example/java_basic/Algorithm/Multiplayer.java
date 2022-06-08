package com.example.java_basic.Algorithm;

// 自定义乘法器
public class Multiplayer {
    public static String multiply(String num1, String num2) throws IllegalArgumentException{
        String result;

        // 1.参数校验
        if(!validateParam(num1) || !validateParam(num2)){
            throw new IllegalArgumentException();
        }

        // 2.判断结果正负
        boolean flag = getFlag(num1) == getFlag(num2);

        // 3.算出小数点后共有几位
        int dotNum = getDotNum(num1) + getDotNum(num2);

        // 4.得到纯数字
        num1 = getCleanNum(num1);
        num2 = getCleanNum(num2);

        // 5.如果数字为0, 则无需计算，直接返回0即可
        if(num1.equals("0") || num2.equals("0")) return "0";

        // 6.计算结果
        long value = getValue(num1, num2);
        if(value == 0){
            return "0";
        }
        result = String.valueOf(value);

        // 7.填充小数点
        result = fillDot(result, dotNum);

        return !flag ? "-" + result : result;
    }

    private static int getDotNum(String num) {
        int result = 0;
        String[] split = num.split("\\.");
        if(split.length > 1){
            result = split[1].length();
        }
        return result;
    }

    private static boolean getFlag(String num) {
        boolean result = true;
        if(num.charAt(0) == '+' || num.charAt(0) == '-'){
            result = num.charAt(0) == '+';
        }
        return result;
    }

    private static String fillDot(String result, int dotNum) {
        if(dotNum > 0){
            StringBuilder sb = new StringBuilder();
            int length = result.length();
            if(dotNum < length){
                sb.append(result, 0, length - dotNum);
                sb.append(".");
                sb.append(result, length - dotNum, length);
            }else{
                sb.append("0.");
                int diff = dotNum - length;
                while(diff-- > 0){
                    sb.append("0");
                }
                sb.append(result);
            }
            result = sb.toString();
        }
        return result;
    }

    private static long getValue(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        long[] array = new long[n];

        for(int j = n-1; j >= 0; j--){
            int add = 0;
            int pow = 0;
            long value3 = 0;
            int value2 = num2.charAt(j) - '0';
            for(int i = m-1; i >= 0; i--){
                int value1 = num1.charAt(i) - '0';
                int value4 = value1 * value2 + add;
                value3 += ((long) Math.pow(10, pow++) * (value4 % 10));
                add = value4 / 10;
            }
            if(add > 0){
                value3 += Math.pow(10, pow) * add;
            }
            array[n - j - 1] = value3;
        }

        long result = 0;
        for(int i = 0; i < array.length; i++){
            result += array[i] * Math.pow(10, i);
        }

        return result;
    }

    private static String getCleanNum(String num) {
        return num.replace("+", "")
                .replace("-", "")
                .replace(".", "");
    }

    private static boolean validateParam(String num) {
        int dotNum = 0;

        char first = num.charAt(0);
        if(first < '0' || first > '9'){
            if(first != '+' && first != '-'){
                return false;
            }
            if(num.length() == 1) return false;
        }

        for(int i = 1; i < num.length(); i++){
            char c = num.charAt(i);
            if(c == '.'){
                dotNum++;
            }else{
                if(c < '0' || c > '9'){
                    return false;
                }
            }
        }

        return dotNum <= 1;
    }

    public static void main(String[] args) {
        String num1;
        String num2;

        // case 1
        num1 = "287";
        num2 = "99";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        // case 2
        num1 = "-99";
        num2 = "287";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        // case 3
        num1 = "-9.9";
        num2 = "2.87";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        num1 = "9.9";
        num2 = "-2.87";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        num1 = "-9.9";
        num2 = "-2.87";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        num1 = "0.1";
        num2 = "-2.87";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        num1 = "2.87";
        num2 = "0.0001";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        // case 4
        num1 = "0";
        num2 = "2.87";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        num1 = "0.0";
        num2 = "2.87";
        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        // case 5
//        num1 = "+";
//        num2 = "2.87";
//        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        // case 6
//        num1 = "a";
//        num2 = "2.87";
//        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));

        // case 7
//        num1 = "99";
//        num2 = "2.8.7";
//        System.out.println(num1 + " * " + num2 + " = " + Multiplayer.multiply(num1, num2));
    }

}
