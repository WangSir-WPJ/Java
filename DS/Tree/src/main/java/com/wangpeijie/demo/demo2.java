package com.wangpeijie.demo;

import com.wangpeijie.simulationTree;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/2
 */
public class demo2 {
    public static void main(String[] args) {
        simulationTree tree=new simulationTree();
        tree.createTree();
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println(tree.size2(tree.root));
    }
}
