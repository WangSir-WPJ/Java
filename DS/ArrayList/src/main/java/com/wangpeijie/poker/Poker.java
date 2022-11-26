package com.wangpeijie.poker;

/**
 * @Author wpj
 * @DateTime 2022/10/18
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Poker {
    private int rank; // 牌面值
    private String suit; // 花色
    private static final String[] SUITS = {"♠", "♥", "♣", "♦"};

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Poker() {
    }

    public Poker(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "["+suit+" "+rank+"]";
    }

    //买一副牌
    public static List<Poker> buyOne(){
        //创建一个List<poker>用来保存所有的牌
        List<Poker> pokers=new ArrayList<>();
        //创建牌
        //一个花色对应13张牌
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 1; j <=13 ; j++) {
                //得到花色
                String suitTmp=SUITS[i];
                //创建一张牌的对象
                Poker poker=new Poker(j,suitTmp);

                pokers.add(poker);
            }
        }
        return pokers;
    }
    //洗牌
    //生成一个随机数(小于当前数去)与当前位置进行交换
    public static void shuffle(List<Poker>pokers){
        //判断是否为空
        if(pokers==null){
            throw new RuntimeException("没有牌");
        }
        //准备生成随机数
        Random random=new Random();
        //开始洗牌
        for (int i = 0; i < pokers.size(); i++) {
            //生成随机数
            int index=random.nextInt(pokers.size());//随机数区间[0,poker.size())
            Poker tmp=pokers.get(i);
            pokers.set(i, pokers.get(index));
            pokers.set(index,tmp);
        }
    }
    //发牌
    public static List<List<Poker>> deal(List<Poker>pokers){
        //创建玩家对象
        List<List<Poker>> Players=new ArrayList<>();//这个集合包含了所有玩家对象
        //定义玩家对象
        for (int i = 0; i < 3; i++) {
            List<Poker> Player=new ArrayList<>();
            //将玩家添加到集合里
            Players.add(Player);
        }
        //开始发牌
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < Players.size(); j++) {
                //获取玩家
                List<Poker>player=Players.get(j);
                //拿一张牌
                Poker poker=pokers.remove(0);//第一张
                player.add(poker);
            }
        }

        return Players;
    }

}