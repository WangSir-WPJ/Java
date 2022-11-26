package com.wangpeijie;


import java.util.Stack;

public class SingleLinkedList {
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node head;

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;

    }

    //尾插法
    public void addLast(int data) {
        //创建新链表
        Node node = new Node(data);
        //判断链表是否为空
        if (head == null) {
            addFirst(data);
            return;
        }
        //后面节点
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    private void checkRange(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("下标非法 i=" + index);
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        //检查index合法性
        checkRange(index);

        //首位
        if (index == 0) {
            addFirst(data);
            return;
        }
        //尾部
        if (index == size()) {
            addLast(data);
            return;
        }
        //中间位置
        //首先找到所找节点的上一节点
        Node preNode = findPreNode(index);
        //创建新节点
        Node node = new Node(data);
        //用node.next引用preNode.next
        node.next = preNode.next;
        //preNode.next引用新节点
        preNode.next = node;
    }

    private Node findPreNode(int index) {
        //创建临时节点
        Node current = head;
        for (int i = 0; i < (index - 1); i++) {
            current = current.next;
        }
        return current;
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        //遍历链表
        Node current = head;
        while (current != null) {
            if (current.value == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        //若为头节点
        if (head.value == key) {
            head = head.next;
            return;
        }
        //不是头节点
        Node current = head;
        while (current != null) {
            if (current.next.value == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        //判断链表是否为空
        if (head == null) {
            return;
        }
        //出现在首位
        if (head.value == key) {
            head = head.next;
        }
        //不为空
        //两个临时变量
        Node current = head.next;
        Node prev = head;
        while (current != null) {
            if (current.value == key) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    //得到单链表的长度
    public int size() {
        //遍历每个节点，统计节点个数
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void clear() {

        //手动将每个节点置空
        Node current = head;
        while (current != null) {
            //得到下一个节点
            Node nextNode = current.next;
            current.next = null;
            current = nextNode;
        }

        //最简便方法
        head = null;
    }

    public void display() {
        //创建一个临时变量引用head
        Node current = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (current != null) {
            sb.append(current.value);
            //最后一个节点不加空格
            if (current.next != null) {
                sb.append(" ");
            }
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
        /*while(current!=null){
            System.out.print(current.value+" ");
            current=current.next;
        }
        System.out.println();*/
    }

    public void printList() {
        if (head == null) {
            System.out.println("");
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null){
            stack.push(current);
            current=current.next;
        }
        while(!stack.empty()){
            System.out.print(stack.pop().value+" ");
        }
        System.out.println();
    }
}
