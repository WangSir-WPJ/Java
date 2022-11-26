package com.wangpeijie.OJ;

import java.util.Stack;

/**
 * 括号匹配
 *
 * @Author 王珮杰
 * @DateTime 2022/10/24
 */
public class OJ1 {
    /**
     * 有效的括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //定义一个栈用来存放左括号
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                //获取栈顶元素与右括号匹配
                char top = stack.peek();
                if (top == '(' && ch == ')' || top == '[' && ch == ']' || top == '{' && ch == '}') {
                    //出栈
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 栈的压入、弹出序列
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            if (!stack.isEmpty() && j < pushA.length && stack.peek() == popA[i]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    /**
     * 逆波兰表达式
     * 将操作数放入栈中，当遇到操作符时取出2个元素进行运算
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            //判断
            String str = tokens[i];
            boolean b1=isOperator(str);
            if (b1) {
                int right = stack.pop();
                int left = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(left+right);
                        break;
                    case "-":
                        stack.push(left-right);
                        break;
                    case "*":
                        stack.push(left*right);
                        break;
                    case "/":
                        stack.push(left/right);
                        break;
                }

            } else {
                stack.push(Integer.valueOf(str));
            }

        }
        return stack.peek();
    }

    private boolean isOperator(String str) {
        if (str == null || str == "") {
            return false;
        }
        if (str.equals("+")|| str.equals("-") || str.equals("*")|| str.equals("/")) {
            return true;
        }
        return false;
    }
}
