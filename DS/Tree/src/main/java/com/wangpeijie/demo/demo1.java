package com.wangpeijie.demo;

import com.wangpeijie.BinaryTree;

/**
 * @Author 王珮杰
 * @DateTime 2022/10/24
 */
public class demo1 {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.create();
        tree.postOrder(tree.root);
        /*System.out.println(tree.size(tree.root));
        System.out.println(tree.size1(tree.root));
        System.out.println(tree.getLeafNodeCount(tree.root));
        System.out.println(tree.getLeafNodeCount1(tree.roo t));
        System.out.println(tree.getKLevelNodeCount(tree.root, 3));
        System.out.println(tree.getHeight(tree.root));*/
        //System.out.println(tree.find(tree.root, 4));
        tree.levelOrder(tree.root);
    }
}
