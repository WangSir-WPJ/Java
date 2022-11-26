package com.wangpeijie;

import java.util.LinkedList;

/**
 * 利用双向链表实现队列
 * @Author 王珮杰
 * @DateTime 2022/10/21
 */
public class MyQueue {
    //1、定义一个静态双向链表节点的类
    public static class ListNode{
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //头节点
    public ListNode head;
    //尾节点
    public ListNode tail;
    //对列
    public int size;

    /**
     * 入队  从对尾入
     * @param e
     */
    public void offer(int e){
        ListNode node=new ListNode(e);

        if (head==null){
            //空链表
            head=node;
        }else{
            tail.next=node;
            node.prev=tail;
        }
        tail=node;
        size++;
    }

    /**
     * 出栈 ，从队头出
     */
    public int poll(){
        if (isEmpty()){
            throw new RuntimeException("队列为空.");
        }
        //获取对头元素
        int headVal= head.val;
        head=head.next;
        if (head==null){
            tail=null;
        }else {
            //处理前驱节点
            head.prev.next=null;

            head.prev=null;
        }
        size--;
        return headVal;
    }

    /**
     * 获取队头元素
     * @return
     */
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空.");
        }
        return head.val;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void display(){
        StringBuffer sb=new StringBuffer();
        ListNode current=head;
        sb.append("[");
        while (current!=null){
            sb.append(current.val);
            if (current.next!=null){
                sb.append(" ");
            }
            current=current.next;
        }
        sb.append("]");
        System.out.println(sb);
    }
}
