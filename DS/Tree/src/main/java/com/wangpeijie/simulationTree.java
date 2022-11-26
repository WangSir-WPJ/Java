package com.wangpeijie;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/2
 */
public class simulationTree {
    private static class TreeNode {
        public char val;
        public TreeNode left;//左孩子的引用
        public TreeNode right;//右孩子的引用

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode root;

    /**
     * 创建一棵二叉树 返回这棵树的根节点
     *
     * @return
     */
    public void createTree() {
// 先所有的节点创建出来

        TreeNode node1 = new TreeNode('A');
        TreeNode node2 = new TreeNode('B');
        TreeNode node3 = new TreeNode('C');
        TreeNode node4 = new TreeNode('D');
        TreeNode node5 = new TreeNode('E');
        TreeNode node6 = new TreeNode('F');
        TreeNode node7 = new TreeNode('G');
        TreeNode node8 = new TreeNode('H');
        // 处理引用关系
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node8;
        node3.left = node6;
        node3.right = node7;
        // 指定根节点的引用
        root = node1;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
        System.out.println();
    }

    public static int nodeSize;

    /**
     * 获取树中节点的个数：遍历思路
     */
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
        return nodeSize;
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left) + size2(root.right) + 1;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    public int getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null || root.right == null) {
            return leafSize++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
        return leafSize;
    }

    /*
     获取叶子节点的个数：子问题
     */
    public int getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount1(root.right);
    }

    /*
    获取第K层节点的个数
     */
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null||k<=0) {
            return 0;
        }
        if (k==1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }


    // 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, char val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }
        TreeNode left=find(root.left,val);
        TreeNode right=find(root.right,val);
        if (left!=null){
            return left;
        }
        if (right!=null){
            return right;
        }
        return null;
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if (root==null){
            return;
        }
        //辅助队列存放结点
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.print(node.val+" ");
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        System.out.println();

    }


    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        //用队列辅助存放节点
        Queue<TreeNode> queue = new LinkedList<>();
        //存放头节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            //出队一个元素
            TreeNode node = queue.poll();
            if (node != null) {
                //节点不为空，所有元素都入队
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                //节点为空全部出队，遇到非空元素，返回false
                while (!queue.isEmpty()) {
                    TreeNode checkNode = queue.poll();
                    if (checkNode != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
