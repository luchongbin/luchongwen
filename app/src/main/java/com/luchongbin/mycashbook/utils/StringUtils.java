package com.luchongbin.mycashbook.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class StringUtils {
    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
    public static long genItemId() {
//取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
//long millis = System.nanoTime();
//加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
//如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }
    //保留index位小数
    public static String  formatDouble(double mData){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(mData);
    }
    //保留1位小数
    public static String  formatDouble1(double mData){
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(mData);
    }
}
