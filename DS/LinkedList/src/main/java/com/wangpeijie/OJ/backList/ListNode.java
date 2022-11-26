package com.wangpeijie.OJ.backList;

/**
 * 链表倒数第k个节点
 * nowCoder
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
 class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(k-1>0){
            fast=fast.next;
            if(fast==null){
                return null;
            }
            k--;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
