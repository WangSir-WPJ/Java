package com.wangpeijie;

/**
 * @Author 王珮杰
 * @Date 2022-11-14
 */
public class BinarySearchTree {
    // 定义节点类
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    // 定义一个根节点的引用
    public TreeNode root;

    /**
     * 查找指定的值是否存在
     * @param value
     * @return
     */
    public boolean search(int value) {
        if(root==null){
            return false;
        }
        TreeNode current=root;
        while (current!=null){
            if (value== current.value){
                return true;
            }
            if (value< current.value){
                current= current.left;
            }else {
                current=current.right;
            }
        }
        return false;
    }

    /**
     * 插入一个元素
     * @param value 要插入的值
     * @return
     */
    public boolean insert(int value) {
        TreeNode node=new TreeNode(value);
        if (root==null){
            root=node;
            return true;
        }
        TreeNode current=root;//用来遍历
        TreeNode prev=null;//用来记录父节点
        while(current!=null){
            if (value==current.value){
                return false;
            }
            //找要插入的位置
            prev=current;
            if (value<current.value){
                current=current.left;
            }else {
                current= current.right;
            }
        }
        if (value< prev.value){
            prev.left=node;
        }else {
            prev.right=node;
        }
        return true;

    }

    /**
     * 删除指定的元素
     * @param value 要删除的元素
     * @return
     */
    public boolean remove(int value) {
        if (root==null){
            return false;
        }
        TreeNode current=root;
        TreeNode parent=null;
        while (current!=null){
            if (value==current.value){
                removeNode(parent,current);
                return  true;
            }
            parent=current;
            if (value<current.value){
                current=current.left;
            }else {
                current= current.right;
            }
        }
        return false;
    }

    private void removeNode(TreeNode parent, TreeNode current) {
        if (current.left==null){
            if (current==root){
                root=current.right;
            } else if (current==parent.left) {
                parent.left=current.right;
            }else {
                parent.right= current.right;
            }

        }else if (current.right==null){
            if (current==root){
                root=current.left;
            } else if (current==parent.left) {
                parent.left=current.left;
            }else {
                parent.right= current.left;
            }
        }else{
            TreeNode target=current.right;
            TreeNode parentTarget=current;
            //向左找最小值
            while (target.left!=null){
                parentTarget=target;
                target=target.left;
            }
            //到达叶子节点
            current.value=target.value;
            //删除target节点
            if (target==parentTarget.left){
                parentTarget.left=target.right;
            }else {
                parentTarget.right=target.right;
            }


        }
    }

    /**
     * 中序遍历
     * @param node
     * @return
     */
    public String inorder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            return sb.toString();
        }
        // 先处理左
        String left = inorder(node.left);
        sb.append(left);
        // 处理根节点
        sb.append(node.value + " ");
        // 处理右
        String right = inorder(node.right);
        sb.append(right);
        return sb.toString();
    }
}
