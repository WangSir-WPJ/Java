package com.wangpeijie.OJ;
import java.util.Scanner;
/**
 * 二叉树遍历
 * @Author 王珮杰
 * @DateTime 2022/11/8
 */
public class BinaryTree {
    //定义一个二叉树类
    private static class TreeNode{
        char value;
        TreeNode left;
        TreeNode right;

        public TreeNode(char value) {
            this.value = value;
        }
    }
    //构建二叉树(核心)
    private static int index=0;
    private static TreeNode buildBinaryTree(String str){
        if (str==null||str.equals("")){
            return null;
        }
        //处理字符串
        char ch=str.charAt(index);
        TreeNode root=null;
        //字符判断
        if (ch!='#'){
            root=new TreeNode(ch);
            index++;
            root.left=buildBinaryTree(str);
            root.right=buildBinaryTree(str);

        }else{
            index++;
        }
        return root;
    }
    //中序遍历
    private static void inorder(TreeNode root){
        if (root==null){
            return;
        }
        //左-根-右
        inorder(root.left);
        System.out.print(root.value+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str=in.nextLine();
            TreeNode root=buildBinaryTree(str);
            inorder(root);
        }
    }
}
