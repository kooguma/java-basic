package algorithms.nowcoder;

import java.util.EmptyStackException;
import java.util.Stack;

//leetcode 155 设计一个有getMin功能的栈

/**
 * 思路1：stackData stackMin
 * 思路2：
 *
 *  int min = Integer.MAX_VALUE
 *  Stack<Integer> stack = new Stack<~>();
 *
 *  public void push(int x){
 *
 *      if(x <= min){
 *          stack.push(min);
 *          min = x;
 *      }
 *
 *      stack.push(x);
 *  }
 *
 *  public void pop(){
 *      int x = stack.pop() ;
 *      if(x == min) min = stack.pop();
 *  }
 *
 *
 *  public int getMin(){
 *      return min;
 *  }
 *
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
            }
            stackData.push(value);
        }
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new EmptyStackException();
        } else {
            int value = stackData.peek();
            int min = stackMin.peek();
            if (value == min) {
                return stackMin.pop();
            }
            return stackData.pop();
        }
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackMin.peek();
    }


}
