package com.wangpeijie;

import java.util.Random;
import java.util.Stack;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/8
 */
public class Sort {
    /**
     * 插入排序
     * 时间复杂度:最坏情况:O(N^2),最好情况 O(N)
     * 空间复杂度:O(1)
     * 稳定性:稳定
     * @param array
     */
    public  void insertSort(int []array){
        for (int i = 1; i < array.length ; i++) {
            int temp=array[i];
            int j=i-1;
            while(j>=0){
                //说明前面的已经有序了
                if (array[j]<=temp){
                    break;
                }
                //移动j的值到j+1
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
    }

    public void testInsertSort(int []array){
        long begin=System.currentTimeMillis();
        insertSort(array);
        long end=System.currentTimeMillis();
        System.out.println("插入耗时:"+(end-begin));
    }
    /**
     * 希尔排序(缩小增量法)-入口方法
     * 将数组分组
     * @param array
     */
    public  void shellSort(int []array){
        //1、确定分组大小
        int gap=array.length/2;
        while(gap>0){
            shell(array,gap);
            gap/=2;
        }
    }

    /**
     * 希尔排序核心方法
     * 时间复杂度:O(N^1.25)~O(N^1.5)
     * 空间复杂度:O(1)
     * 稳定性:不稳定
     * @param array
     * @param gap
     */
    private  void shell(int[] array, int gap) {
        for (int i = gap; i < array.length ; i++) {
            int temp=array[i];
            int j=i-gap;
            while(j>=0){
                if (array[j]<=temp){
                    break;
                }
                array[j+gap]=array[j];
                j-=gap;
            }
            array[j+gap]=temp;
        }
    }
    public void testShellSort(int []array){
        long begin=System.currentTimeMillis();
        shellSort(array);
        long end=System.currentTimeMillis();
        System.out.println("希尔耗时:"+(end-begin));
    }
    /**
     * 直接排序
     * 时间复杂度:O(N^2)
     * 空间复杂度:O(1)
     * 稳定性:不稳定
     * @param array
     */
    public void selectSort(int []array){
        for (int i = 0; i < array.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <array.length ; j++) {
                if (array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    private void swap(int[] array, int i, int minIndex) {
        int temp=array[i];
        array[i]=array[minIndex];
        array[minIndex]=temp;
    }

    public void testSelectSort(int []array){
        long begin=System.currentTimeMillis();
        selectSort(array);
        long end=System.currentTimeMillis();
        System.out.println("直接耗时:"+(end-begin));
    }
    /**
     * 直接排序(优化)-直接找到最大值和最小值
     * @param array
     */
    public void selectSort1(int []array){
        int left=0;
        int right= array.length-1;
        while(left<right){
            int minIndex=left;
            int maxIndex=left;
            //找最大值和最小值
            for (int i = left+1; i <=right ; i++) {
                if (array[i]<array[minIndex]){
                    minIndex=i;
                }
                if (array[i]>array[maxIndex]){
                    maxIndex=i;
                }
            }
            if (left!=minIndex){
                swap(array,left,minIndex);
            }
            if (left==maxIndex){
                minIndex=maxIndex;
            }
            if (right!=maxIndex){
                swap(array,right,maxIndex);
            }
            left++;
            right--;
        }
    }
    public void testSelect1Sort(int []array){
        long begin=System.currentTimeMillis();
        selectSort1(array);
        long end=System.currentTimeMillis();
        System.out.println("直接(优化)耗时:"+(end-begin));
    }

    /**
     * 堆排序
     * 时间复杂度:O(N*logN)
     * 空间复杂度:O(1)
     * 稳定性:不稳定
     * 排升序需要建大根堆,降序小根堆
     * @param array
     */
    public void headSort(int []array){
        creatHeap(array);
        int end=array.length-1;
        while (end>=0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    private void creatHeap(int[] array) {
        //找到最后一个度不为0的根节点
        for (int parent = (array.length-2)/2; parent >=0 ; parent--) {
            shiftDown(array,parent,array.length);
        }
    }

    private void shiftDown(int[] array, int parent, int length) {
        int child=parent*2+1;
        while (child<length){
            if (child+1<length){
                if (array[child]<array[child+1]){
                    child++;
                }
            }
            if (array[child]<=array[parent]){
                break;
            }
            swap(array,parent,child);
            parent=child;
            child=2*parent+1;
        }
    }

    public void testHeadSort(int []array) {
        long begin = System.currentTimeMillis();
        headSort(array);
        long end = System.currentTimeMillis();
        System.out.println("堆耗时:" + (end - begin));
    }

    /**
     * 冒泡排序
     * 时间复杂度:O(N^2)
     * 空间复杂度:O(1)
     * 稳定性:稳定
     * @param array
     */
    public void bubbleSort(int[]array){
        for (int i = 0; i < array.length-1; i++) {
            boolean flag=false;
            for (int j = i+1; j <array.length-1-i ; j++) {
                if (array[j]>array[j+1]){
                    swap(array,j,j+1);
                    flag=true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    /**
     * 快速排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(logN)
     * @param array
     */
    public void quickSort(int []array){
        quickSortProcess(array,0,array.length-1);
        //quickSortProcess1(array,0,array.length-1);
        //quickSortProcess2(array,0,array.length-1);
        quickSortProcess3(array,0,array.length-1);

    }

    //优化-解决有序数组进行排序中出现栈溢出问题
    private void quickSortProcess3(int[] array, int left, int right) {
        if (left>=right){
            return;
        }
        int mid=midValueIndex(array,left,right);
        swap(array,left,mid);
        //找基准
        int pivot= partitionHoare(array,left,right);
        quickSortProcess(array,left,pivot);
        quickSortProcess(array,pivot+1,right);
    }


    //hoare
    private void quickSortProcess(int[] array, int left, int right) {
        if (left>=right){
            return;
        }
        //找基准
        int pivot= partitionHoare(array,left,right);
        quickSortProcess(array,left,pivot);
        quickSortProcess(array,pivot+1,right);
    }

    //挖坑
    private void quickSortProcess1(int[] array, int left, int right) {
        if (left>=right){
            return;
        }
        //找基准
        int pivot= partitionHole(array,left,right);
        quickSortProcess1(array,left,pivot);
        quickSortProcess1(array,pivot+1,right);
    }
    //快慢指针
    private void quickSortProcess2(int[] array, int left, int right) {
        if (left>=right){
            return;
        }
        //找基准
        int pivot= partitionPointer(array,left,right);
        quickSortProcess2(array,left,pivot);
        quickSortProcess2(array,pivot+1,right);
    }

    //找基准(hoare)
    private int partitionHoare(int[] array, int left, int right) {

        int pivotValue=array[left];
        int pivotIndex=left;
        while(left<right){
            while(left<right&&array[right]>=pivotValue){
                right--;
            }
            while (left<right&&array[left]<=pivotValue){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,left,pivotIndex);
        return left;
    }

    /**
     * 三位取中
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int midValueIndex(int[] array, int left, int right){
        int mid=(left+right)/2;

        if (array[left]<array[right]){
            //左小右大
            if (array[mid]>array[right]){
                return right;
            }else if (array[mid]<array[left]){
                return left;
            }else{
                return mid;
            }

        }else {
            //左大右小
            if (array[mid]>array[left]){
                return left;
            }else if (array[mid]<array[right]){
                return right;
            }else{
                return mid;
            }
        }
    }


    /**
     * 快排(挖坑法)
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int partitionHole(int[] array, int left, int right) {
        int pivotValue=array[left];
        while(left<right){
            while(right>left&&array[right]>=pivotValue){
                right--;
            }
            array[left]=array[right];
            while(left<right&&array[left]<=pivotValue){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=pivotValue;

        return left;

    }

    /**
     * 快慢指针
     * @param array
     * @param left
     * @param right
     * @return
     */
    private int partitionPointer(int[] array, int left, int right) {
        int prev=left;
        int current=left+1;
        while(current<=right){
            if (array[current]<array[left]){
                prev++;
                if (array[prev]!=array[current]){
                    swap(array,current,prev);
                }
            }
            current++;
        }
        swap(array,prev,left);
        return prev;
    }

    public void quickSourItr(int []array){
        //1、定义一个栈用来保存左右下标
        Stack<Integer>stack=new Stack<>();
        int left=0;
        int right=array.length-1;
        //2、三位取中
        int mid=midValueIndex(array,left,right);
        swap(array,left,mid);
        //3、找基准
        int pivot=partitionHoare(array,left,right);
        //4、入栈
        if (left+1<pivot){
            //左下标
            stack.push(left);
            //右下标
            stack.push(pivot-1);
        }
        if (right-1>pivot){
            stack.push(pivot+1);
            stack.push(right);
        }
        while(!stack.isEmpty()){
            right=stack.pop();
            left=stack.pop();
            mid=midValueIndex(array,left,right);
            swap(array,left,mid);
            //3、找基准
            pivot=partitionHoare(array,left,right);
            //4、入栈
            if (left+1<pivot){
                //左下标
                stack.push(left);
                //右下标
                stack.push(pivot-1);
            }
            if (right-1>pivot){
                stack.push(pivot+1);
                stack.push(right);
            }
        }


    }

    //=======================耗时=======================
    public void testQuickSort(int []array) {
        long begin = System.currentTimeMillis();
        quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println("快排耗时:" + (end - begin));
    }

    //===============归并排序=================

    /**
     * 归并排序
     * 时间复杂度:O(N*logN)
     * 空间复杂度:O(N)
     * 稳定性:稳定
     * @param array
     */
    public void mergeSort(int[]array){
        mergeSortProcessor(array,0,array.length-1);
    }

    private void mergeSortProcessor(int[] array, int left, int right) {
        //1、终止条件
        if (left>=right){
            return;
        }
        //2、找中间下标
        int mid=(left+right)/2;
        //3、分解左右区段
        mergeSortProcessor(array,left,mid);
        mergeSortProcessor(array,mid+1,right);
        //4、合并
        marge(array,left,mid,right);
    }

    private void marge(int[] array, int left, int mid, int right) {
        //1、创建临时数组
        int []temp=new int[right-left+1];
        int index=0;
        //2、确定每个小数组的下标
        int start1=left;
        int end1=mid;
        int start2=mid+1;
        int end2=right;
        //3、合并
        while (start1<=end1&&start2<=end2){
            if (array[start1]<array[start2]){
                temp[index++]=array[start1++];
            }else {
                temp[index++]=array[start2++];
            }
        }
        //剩余元素添加到temp中
        while(start1<=end1){
            temp[index++]=array[start1++];
        }
        while (start2<=end2){
            temp[index++]=array[start2++];
        }
        //4、temp写到原数组中
        for (int i = 0; i <temp.length ; i++) {
            array[i+left]=temp[i];
        }
    }

    /**
     * 归并排序-迭代
     * @param array
     */
    public void mergeSortItr(int[]array){
        //定义步长
        int gap=1;
        //循环
        while(gap<array.length){
            for (int i = 0; i < array.length; i+=2*gap) {
                //确定左中右下标
                int left=i;
                int mid=i+gap-1;
                int right=mid+gap;
                //修正下标
                if (mid> array.length){
                    mid= array.length-1;
                }
                if (right> array.length-1){
                    right= array.length-1;
                }
                //归并
                marge(array,left,mid,right);
            }
            //调整gap的值
            gap*=2;
        }
    }
    //===============计数排序==================

    /**
     * 计数排序
     * 时间复杂度：O(MAX(范围, N))
     * 空间复杂度：O(范围)
     * @param array
     */
    public void countSort(int []array){
        int minVal=array[0];
        int maxVal=minVal;
        //找最大值与最小值
        for (int i = 0; i < array.length; i++) {
            if (array[i]<minVal){
                minVal=array[i];
            }
            if (array[i]>maxVal){
                maxVal=array[i];
            }
        }
        //创建一个容量为max-min+1 的数组
        int [] countArray=new int[maxVal-minVal+1];
        //用元素的值-min得到计数数组的下标
        for (int i = 0; i < array.length; i++) {
            int index=array[i]-minVal;
            countArray[index]++;
        }
        int index=0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i]>0){
                int val=i+minVal;
                array[index++]=val;
                countArray[i]--;
            }
        }
    }

    //===============生成数组==================
    private static int CAPACITY=1000_0000;

    public  int[] initUnderArray() {
        int []array=new int[CAPACITY];
        Random random=new Random();
        for (int i = 0; i < array.length; i++) {
            int val=random.nextInt(CAPACITY);
            array[i]=val;
        }
        return array;
    }



    public  int[] initOrderArray() {
        int []array=new int[CAPACITY];
        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
        return array;
    }

}
