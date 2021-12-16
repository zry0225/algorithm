package com.zry.test;

import java.util.Stack;

/**
 * @author zry
 * @Date 2021/12/8
 * @ApiNote
 * 一个栈中元素的类型为整型, 现在想将该栈从顶到底按从大到小的顺序排序, 只许申
 * 请一个栈。除此之外,可以申请新的变量,但不能申请额外的数据结构。如何完成排序?
 */
public class SortStackByStack {
    /**
     * 辅助排序的栈记为help，在stack上进行弹栈操作（pop），弹出的元素记为cur
     * 如果cur比help栈顶元素小或者等于，则压入help
     * 如果cur比help栈顶元素大，则逐一将help的元素弹出并压入stack，并与cur进行比较，直到cur小于等于help栈顶元素，
     * 将cur压入，循环直到stack为空
     * @param stack 需要排序的栈
     */
    public static void sortStackByStack(Stack<Integer> stack){

        Stack<Integer> help = new Stack<>();

        while (!stack.empty()){
            int cur = stack.pop();
            //如果cur比help栈顶元素大，则逐一将help的元素弹出并压入stack，并与cur进行比较，直到cur小于等于help栈顶元素
            while (!help.empty() && cur>help.peek()){
                stack.push(help.pop());
            }
            //将cur压入help栈
            help.push(cur);
        }
        //将元素压入stack栈，与help中栈的从小到大相反，满足要求
        while (!help.empty()){
            stack.push(help.pop());
        }

    }
}
