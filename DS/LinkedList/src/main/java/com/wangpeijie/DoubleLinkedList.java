package com.wangpeijie;

import java.util.List;

/**
 * @Author 王珮杰
 * @DateTime 2022/10/18
 */
public class DoubleLinkedList {
    public static class ListNode {
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

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            //链表为空的情况下
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            //链表为空的情况下
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        //判断位置是否合法
        checkCharge(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        //找到要插入位置的节点
        ListNode current = findCurrentNode(index);
        //创建要插入的节点
        ListNode node = new ListNode(data);

        node.prev = current.prev;
        node.next = current;
        node.prev.next = node;
        node.next.prev = node;
    }

    private void checkCharge(int index) {
        if (index < 0 && index > size()) {
            throw new IndexOutOfBoundsException("非法坐标 index=" + index);
        }
    }

    private ListNode findCurrentNode(int index) {
        ListNode current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode current = head;
        while (current != null) {
            if (current.val == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null) {
            if (current.val == key) {
                if (current == head) {
                    head = head.next;
                    //删除头节点
                    if (head == null) {
                        tail = null;
                    } else {
                        //若只剩一个节点
                        head.prev.next = null;
                        head.prev = null;
                    }
                } else if (current == tail) {
                    //处理尾节点
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;

                }
                return;

            }
            current = current.next;
        }

    }
    public void removeAllKey(int key) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null) {
            if (current.val == key) {
                if (current == head) {
                    head = head.next;
                    //删除头节点
                    if (head == null) {
                        tail = null;
                    } else {
                        //若只剩一个节点
                        head.prev = null;
                    }
                } else if (current == tail) {
                    //处理尾节点
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }
    }

    //得到单链表的长度
    public int size() {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }



    public void display() {
        //遍历链表
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" ");
            }
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb);

    }

    public void clear() {
        /*ListNode current=head;
        while(current!=null){
            ListNode tempNode=current.next;
            current.prev=null;
            current.next=null;
            current=tempNode;
        }*/
        head = null;
        tail = null;
        //利用GC垃圾回收器销毁堆中数据
    }
}
