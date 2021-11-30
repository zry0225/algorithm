import java.util.Stack;

/**
 * @author yan
 * 使用递归和一个栈将其逆序
 */
public class ReverseStack {

    public static int getAndRemoveElement(Stack<Integer> stack){
        //出栈
        int result = stack.pop();
        //如果栈是空的直接返回
        if (stack.empty()){
            return result;
        }else {
            //使用递归，获得栈底元素
            int last = getAndRemoveElement(stack);
            //把栈顶元素压入
            stack.push(result);
            //返回栈底元素
            return last;
        }
    }

    /**
     * 逆序
     * @param stack 栈
     */
    public static void reverse(Stack<Integer> stack){
        if (stack.empty()){
            return;
        }
        //获得栈底元素
        int i = getAndRemoveElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
