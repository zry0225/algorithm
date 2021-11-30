import java.util.Stack;

/**
 * @author yan
 * 使用两个栈实现队列先入先出
 */
public class TowStackQueue {
    private final Stack<Integer> stackPush;
    private final Stack<Integer> stackPop;

    public TowStackQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void add(int pushNum){
        stackPush.push(pushNum);
    }

    /**
     * 出队
     * @return
     */
    public int poll(){
        if (stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("队列为空");
        }else if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }


    public static void main(String[] args) {
        TowStackQueue towStackQueue = new TowStackQueue();
        int cont = 10;
        for (int i = 1; i <= cont; i++) {
            towStackQueue.add(i);

        }
        for (int i = 1; i <= cont; i++) {
            System.out.println(towStackQueue.poll());
        }

    }
}
