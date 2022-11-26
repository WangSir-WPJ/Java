package com.wangpeijie.OJ.removeAllVal;
/**
 * 203. 移除链表元素
 * LeetCode
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode preNode=head;
        ListNode current=head.next;
        while(current!=null){
            if(current.val!=val){
                preNode=current;
            }else{
                preNode.next=current.next;
            }
            current=current.next;
        }
        if(val==head.val){
            head=head.next;
        }
        return head;
    }
}