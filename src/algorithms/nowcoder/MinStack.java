package algorithms.nowcoder;

import java.util.EmptyStackException;
import java.util.Stack;

//设计一个有getMin功能的栈

/**
 * 思路：
 */
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int value) {
        if (stackData.isEmpty()) {
            stackData.push(value);
            stackMin.push(value);
        } else {
            int min = stackMin.peek();
            if (value <= min) {
                stackMin.push(value);
            } else {
                stackData.push(value);
            }

        }
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new EmptyStackException();
        }else {
            int value = stackData.peek();
            int min = stackMin.peek();
            if(value == min){
                return stackMin.pop();
            }else {
                return stackData.pop();
            }
        }
    }

    public int getMin() {
        if(stackMin.isEmpty()){
            throw new EmptyStackException();
        }
        return stackMin.peek();
    }


}
