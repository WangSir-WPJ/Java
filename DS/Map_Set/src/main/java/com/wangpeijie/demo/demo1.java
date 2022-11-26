package com.wangpeijie.demo;

import com.wangpeijie.BinarySearchTree;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/19
 */
public class demo1 {
    public static void main(String[] args) {
        int[] array2 = {5,3,7,1,4,6,8,0,2,9};
        int[]array={7,2,4,6,3,1,5};
        BinarySearchTree tree=new BinarySearchTree();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        tree.insert(8);

        System.out.println(tree.inorder(tree.root));
        System.out.println(tree.search(4));
        System.out.println(tree.search(10));
        System.out.println(tree.remove(7));
        System.out.println(tree.inorder(tree.root));


    }
}
