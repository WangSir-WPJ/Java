package com.wangpeijie;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/20
 */
public class HashBucket {
    //定义一个节点
    private static class Node{
        private int key;
        private int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //定义哈希桶
    private Node []bucket;
    //定义有效个数
    private int size;
    //定义负载因子
    private float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashBucket(){
        bucket=new Node[8];
    }
    /**
     * 写入操作
     * @param key
     * @param value
     * @return
     */
    public int put (int key, int value) {
        //1、根据key值计算下标
        int index=key%bucket.length;
        //2、检查下标
        Node current=bucket[index];
        //2.1遍历链表
        while(current.next!=null){
            if (current.key==key){
                //2.2覆盖
                int oldValue=current.value;
                current.value=value;
                return oldValue;
            }
        }
        //3、创建新节点
        Node node=new Node(key,value);
        //4、头插
        node.next=bucket[index];
        bucket[index]=node;
        //5、有效个数+1
        size++;
        //6、判断当前元素个数是否超过负载因子
        if (loadFactor()>=DEFAULT_LOAD_FACTOR){
            //扩容
            resize();
        }
        return value;
    }

    private void resize() {
    }

    private float loadFactor() {
        return size*1.0f/bucket.length;
    }

    public int get (int key) {

        return 0;
    }
}
