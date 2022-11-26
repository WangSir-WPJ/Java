package com.wangpeijie.demo;

import java.util.*;

/**
 * TreeMap的应用
 * @Author 王珮杰
 * @DateTime 2022/11/19
 */
public class demoTreeMap {
    public static void main(String[] args) {
        Map<Integer,String> treeMap=new TreeMap<>();
        System.out.println("============= 写入null ============");
        //treeMap.put(null,"null");//抛出空指针异常
        System.out.println(treeMap);

        treeMap.put(1,"hello");
        treeMap.put(2,"1122");
        treeMap.put(3,"3344");
        treeMap.put(68,"4455");
        treeMap.put(34,"5566");
        System.out.println(treeMap);
        //获取k值对应的value
        System.out.println(treeMap.get(3));
        System.out.println(treeMap.get(99));//没有返回null
        System.out.println("============================");
        System.out.println(treeMap.getOrDefault(1, "没有value"));
        System.out.println(treeMap.getOrDefault(99, "没有value"));
        System.out.println("============================");
        //System.out.println(treeMap.remove(1));
        System.out.println(treeMap.remove(122));//没有返回null
        System.out.println(treeMap);
        //
        treeMap.put(4,"3344");
        System.out.println(treeMap);
        //获取所有的key值
        Set<Integer>keySet=treeMap.keySet();
        System.out.println(keySet);
        //获取所有的value值
        Collection<String>values=treeMap.values();
        System.out.println(values);
        //判断是否包含某个值
        System.out.println("=======================");
        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.containsKey(88));
        System.out.println("=======================");
        System.out.println(treeMap.containsValue("1122"));
        System.out.println(treeMap.containsValue("haha"));
        System.out.println("================= 遍历 ==================");
        func1(treeMap);
        System.out.println("================= 通过Map.Entry对象遍历 ==================");
        func2(treeMap);
        System.out.println("================= 通过迭代器进行遍历 ==================");
        fun3(treeMap);

    }

    /**
     * 利用迭代器
     * @param map
     */
    private static void fun3(Map<Integer, String> map) {
        Iterator<Map.Entry<Integer,String>>iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String>entry=iterator.next();
            System.out.println("key="+entry.getKey()+", "+"value="+entry.getValue());

        }
    }
    /**
     * 通过Map.Entry对象遍历
     * @param map
     */
    private static void func2(Map<Integer, String> map) {
        Set<Map.Entry<Integer, String>> keySet= map.entrySet();
        for (Map.Entry<Integer, String> entry:keySet) {
            System.out.println("key="+entry.getKey()+", "+"value="+entry.getValue());
        }
    }

    /**
     * 遍历
     * @param map
     */
    private static void func1(Map<Integer, String> map) {
        //获取所有的key值
        Set<Integer>keySet=map.keySet();
        for (Integer k:keySet) {
            System.out.println("key="+k+", "+"value="+map.get(k));
        }
    }
}
