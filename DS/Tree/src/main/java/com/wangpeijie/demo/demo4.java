package com.wangpeijie.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/9
 */
public class demo4 {
    public static void main(String[] args) {
        String[] coins = { "A", "B", "C", "D", "E" };
        List l = new ArrayList();
        for (int i = 0; i < coins.length; i++)
            l.add(coins[i]);
        ListIterator liter = l.listIterator();
        System.out.println("反转前");
        while (liter.hasNext())
            System.out.println(liter.next());
        Collections.reverse(l);
        liter = l.listIterator();
        System.out.println("反转后");
        while (liter.hasNext())
            System.out.println(liter.next());
    }
}
