package algorithms.nowcoder;

//leetcode 232 编写一个列，用两个栈实现队列，支持队列的基本操作（add、poll、peek）

import java.util.Queue;
import java.util.Stack;

/**
 * 思路
 */
public class TwoStacksQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int value) {
        stackPush.add(value);
    }

    public int poll() {
        while (!stackPush.isEmpty()) {
            int popValue = stackPush.pop();
            stackPop.push(popValue);
        }
        if (!stackPop.isEmpty()) {
            int pollValue = stackPop.pop();
            while (!stackPop.isEmpty()) {
                int x = stackPop.pop();
                stackPush.push(x);
            }
            return pollValue;
        } else {
            throw new RuntimeException("Empty Queue!");
        }
    }

    public int peek() {
        while (!stackPush.isEmpty()) {
            int popValue = stackPush.pop();
            stackPop.push(popValue);
        }
        if (!stackPop.isEmpty()) {
            int peekValue = stackPop.peek();
            while (!stackPop.isEmpty()){
                int x = stackPop.pop();
                stackPush.push(x);
            }
            return peekValue;
        }else {
            throw new RuntimeException("Empty Queue!");
        }
    }

    public boolean isEmpty(){
        return stackPush.isEmpty();
    }
}
