package zry;

import java.util.Stack;

/**
 * @author yan
 * 设计一个栈，可以弹出最小值
 */
public class MyStack {

    private final Stack<Integer> stackDate;
    private final Stack<Integer> stackMin;

    public MyStack(){
        stackDate = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     * 获取栈最小值
     * @return 最小值
     */
    public int getMin(){

        if (this.stackMin.empty()){
            throw new RuntimeException("栈是空的");
        }
        //按照设计，这个栈栈顶元素就是最小的，直接peek
        return this.stackMin.peek();
    }

    /**
     * 压栈
     * 现在有两个栈，一个正常放数据，另一个当栈中无数据或者栈顶数据大于放入的数据的时候将数据同步压入，
     * 保持该栈栈顶元素为最小
     */
    public void push(int newNum){
        if (this.stackMin.empty()){
            this.stackMin.push(newNum);
            //如果新来的数据小于等于stackMin中的栈顶元素，则压栈
        }else if (newNum<=this.getMin()){
            this.stackMin.push(newNum);
        }
        //压入stackDate栈
        this.stackDate.push(newNum);
    }

    /**
     * 弹栈
     */
    public Integer pop(){
        if (this.stackDate.empty()){
            throw new RuntimeException("栈是空的");
        }
        //弹出栈顶元素
        Integer pop = this.stackDate.pop();
        //如果stackDate栈弹出的元素和stackMin栈的栈顶元素相等，则为最小值
        if (pop == this.getMin()){
            this.stackMin.pop();
            return pop;
        }
        return this.stackMin.pop();

    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(11);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(22);
        System.out.println(myStack.pop());
    }
}
