package com.wangpeijie.OJ.invertLinkedList;

/**
 * 单链表的逆置
 * LeetCode
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode current=head;
        ListNode nextNode=current.next;
        ListNode preNode=null;
        while(current!=null){
            nextNode=current.next;
            current.next=preNode;
            preNode=current;
            current=nextNode;
        }

        return preNode;
    }
}
