package com.wangpeijie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/5
 */
public class TopK {
    /**
     * 方法一:
     * 时间复杂度:O(N^2)
     * 空间复杂度:O(N)
     * @param arr
     * @param k
     * @return
     */
    public int[] TopK1(int[]arr,int k){
        int []result=new int[k];
        if (arr==null){
            return result;
        }
        PriorityQueue<Integer>queue=new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        for (int i = 0; i <k ; i++) {
            result[i]=queue.poll();
        }
        return result;
    }

    /**
     * 方式二:
     * 取最大用小根堆，取最小用大根堆
     * @param arr
     * @param k
     * @return
     */
    public static int[] TopK2(int[]arr,int k){
        int[] result=new int[k];
        if (k<=0){
            return result;
        }
        //建立大根堆
        PriorityQueue<Integer>queue=new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });


        for (int i = 0; i < arr.length ; i++) {
            if (i<k){
                queue.offer(arr[i]);

            }else{
                if (queue.peek()>arr[i]){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }

        }
        for (int i = 0; i < k; i++) {
            result[i]=queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int [] array = { 27,15,19,18,28,34,65,49,25,37 };
        int [] result = TopK2(array, 3);
        System.out.println(Arrays.toString(result));
    }
}
