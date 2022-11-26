package com.wangpeijie.OJ;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class OJTree {

    /**
     * @Author 王珮杰
     * @DateTime 2022/10/22
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {

            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    /**
     * 二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //辅助栈存放结点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            //current不为空时
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    /**
     * 反转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 判断两棵树是否相等
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean leftNode = isSameTree(p.left, q.left);
        boolean rightNode = isSameTree(p.right, q.right);
        return leftNode && rightNode;
    }

    /**
     * 判断是否是对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkIsSymmetric(root.left, root.right);
    }

    private boolean checkIsSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return checkIsSymmetric(p.left, q.right) && checkIsSymmetric(p.right, q.left);
    }

    /**
     * 另一棵树的子树
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //非空校验
        if (root == null || subRoot == null) {
            return false;
        }
        //判断以根节点的树是否相同
        if (isSameTree(root, subRoot)) {
            return true;
        }
        //左树中寻找
        if (isSubtree(root.left, subRoot)) {
            return true;
        }
        if (isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }

    /**
     * 904. 水果成篮
     *
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        //非空校验
        if (fruits.length == 0) {
            return 0;
        }
        int count = 0;
        //遍历数组
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] == 0) {
                continue;
            }
            if (fruits[i] <= 2 || count < 2) {
                count = fruits[i];
            }
            if (i > 0 && fruits[i] > fruits[i - 1] && count != 0) {
                if (count > 2) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

    /**
     * 获取二叉树的高度
     * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/submissions/375238559/
     *
     * @param root
     * @return
     */

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 高度平衡的二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //获取左右子树的高度
        int leftTree = getHeight(root.left);
        int rightTree = getHeight(root.right);

        return Math.abs(leftTree - rightTree) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 从前序与中序遍历序列构造二叉树
     * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //非空校验
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildChileTree(preorder, inorder, 0, inorder.length - 1);


    }

    private int preIndex = 0;

    private TreeNode buildChileTree(int[] preorder, int[] inorder, int begin, int end) {
        if (preIndex > preorder.length - 1 || begin > end) {
            return null;
        }
        //获得前序遍历中节点的值
        int rootVal = preorder[preIndex];
        //根据前序遍历获得的节点值得到在中序遍历中的下标
        int rootIndex = findIndex(inorder, rootVal);
        if (rootIndex == -1) {
            return null;
        }
        preIndex++;
        //创建根节点
        TreeNode root = new TreeNode(rootVal);
        //左节点
        root.left = buildChileTree(preorder, inorder, begin, rootIndex - 1);
        root.right = buildChileTree(preorder, inorder, rootIndex + 1, end);
        return root;
    }

    private int findIndex(int[] inorder, int rootVal) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从中序与后序遍历序列构造二叉树
     * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        //非空校验
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        postIndex = postorder.length - 1;
        return buildChileTree1(inorder, postorder, 0, postIndex);

    }

    private int postIndex;

    private TreeNode buildChileTree1(int[] inorder, int[] postorder, int begin, int end) {
        if (preIndex > postorder.length - 1 || begin > end) {
            return null;
        }
        int rootVal = postorder[postIndex];
        postIndex--;
        int rootIndex = findIndex(inorder, rootVal);
        if (rootIndex == -1) {
            return null;
        }
        TreeNode root = new TreeNode(rootVal);
        root.right = buildChileTree1(inorder, postorder, rootIndex + 1, end);
        root.left = buildChileTree1(inorder, postorder, begin, rootIndex - 1);
        return root;


    }

    /**
     * 二叉树的最近公共祖先
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
     * https://gitee.com/WANG--Peijie/clould-picture/raw/master/Image/202211231359063.png
     *
     * @param root
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //非空校验
        if (root == null || p == null || q == null || p == q) {
            return null;
        }
        //终止条件:p或q为根节点时
        if (p == root || q == root) {
            return root;
        }
        //左右子树中找节点，如果返回空，则说明不在左子树或右子树中
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        //终止条件：左右子树都找到了，返回根节点
        if (leftResult != null && rightResult != null) {
            return root;
        }
        //如果左不为空，右为空，说明在左树中找到了，右子树中没找到
        if (leftResult != null) {
            return leftResult;
        }
        if (rightResult != null) {
            return rightResult;
        }
        //没有找到
        return null;
    }

    /**
     * 根据二叉树创建字符串
     * https://leetcode.cn/problems/construct-string-from-binary-tree/
     *
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        proTree2Str(root, sb);
        return sb.toString();

    }

    private void proTree2Str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        //处理根节点
        sb.append(root.val);
        //处理左子树
        if (root.left != null) {
            sb.append("(");
            proTree2Str(root.left, sb);
            sb.append(")");
        } else {
            //判断有没有右子树,右子树不为空，拼接（）
            if (root.right != null) {
                sb.append("()");
            }
        }
        //处理右子树
        if (root.right != null) {
            sb.append("(");
            proTree2Str(root.right, sb);
            sb.append(")");
        }
    }

    /**
     * 二叉树前序非递归遍历
     * https://leetcode.cn/problems/binary-tree-preorder-traversal/
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        //定义返回集合
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //定义一个栈用来辅助
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            //判断当前节点是否为空
            while (current != null) {
                stack.push(current);
                list.add(current.val);
                current = current.left;
            }
            //当前节点为空
            TreeNode top = stack.pop();
            current = top.right;
        }

        return list;
    }

    /**
     * 二叉树中序非递归遍历
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/submissions/384783734/
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        //定义返回集合
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //定义一个栈用来辅助
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            //判断当前节点是否为空
            while (current != null) {
                stack.push(current);

                current = current.left;
            }
            //当前节点为空
            TreeNode top = stack.pop();
            list.add(top.val);
            current = top.right;
        }

        return list;
    }


    /**
     * 二叉树的后序非递归遍历
     * https://leetcode.cn/problems/binary-tree-postorder-traversal/
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        //定义返回集合
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //定义一个栈用来辅助
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        //定义一个上次处理的节点
        TreeNode prev=null;
        while (current != null || !stack.isEmpty()) {
            //判断当前节点是否为空
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode top=stack.peek();
            if (top.right==null||top.right==prev){
                stack.pop();

                list.add(top.val);
                prev=top;
            }else{
                current=top.right;
            }

        }

        return list;
    }
}
