package com.forezp.thread;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class IsNum {
    //我想找出所有 长度>=5的字符串，并且忽略大小写、去除重复字符串，然后按字母排序，最后用“爱心❤”连接成一个字符串输出！

    public static void main(String[] args) {
        String[] str = {"1", "2", "bilibili", "of", "codesheep", "5", "at", "BILIBILI", "codesheep", "23", "CHEERS", "6"};
        List<Object> list = Arrays.asList(str);
        System.out.println(list);

        List<String> testData = new ArrayList<String>();
        testData.add("张三");
        testData.add("李四");
        testData.add("王二");
        testData.add("麻子");

        testData.stream()
                .filter(x -> x.startsWith("张"))
                .filter(x -> x.length() >= 5);

    }


}
