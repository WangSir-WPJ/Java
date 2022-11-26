package com.wangpeijie.poker;


import java.util.List;

/**
 * @Author wpj
 * @DateTime 2022/10/18
 */
public class demoPoker {
    public static void main(String[] args) {
        //生成一副新牌
        List<Poker> poker =Poker.buyOne();
        System.out.println("生成一副新牌");
        System.out.println(poker);
        System.out.println("================");
        //洗牌
        Poker.shuffle(poker);
        System.out.println("洗牌");
        System.out.println(poker);
        //发牌
        List<List<Poker>> players=Poker.deal(poker);
        System.out.println("发牌");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("玩家"+(i+1)+":"+players.get(i));
        }
        System.out.println("================");
        System.out.println("剩余的牌");
        System.out.println(poker);
    }

}