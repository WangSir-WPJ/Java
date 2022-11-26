package com.wangpeijie.demo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/19
 */
public class demo3 {
    public static void main(String[] args) {
        Map<Integer,String> treeMap=new TreeMap<>();
        treeMap.put(1,"0011");
        treeMap.put(2,"1122");
        treeMap.put(3,"3344");
        treeMap.put(68,"4455");
        treeMap.put(34,"5566");
        System.out.println(treeMap);
        func(treeMap);
        func1(treeMap);
    }

    private static void func1(Map<Integer, String> map) {
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();


    }

    private static void func(Map<Integer, String> map) {
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
    }
}
