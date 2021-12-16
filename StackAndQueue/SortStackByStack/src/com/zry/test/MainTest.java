package com.zry.test;

import java.util.Stack;

/**
 * @author zry
 * @Date 2021/12/8
 * @ApiNote
 */
public class MainTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(9);

        SortStackByStack.sortStackByStack(stack);
        System.out.println("stack = " + stack);

    }
}
