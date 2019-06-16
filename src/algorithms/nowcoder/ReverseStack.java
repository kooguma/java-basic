package algorithms.nowcoder;

import java.util.Stack;

//仅用递归函数和栈操作逆序一个栈
public class ReverseStack {

    public void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        int i = getAndRemoveStackLastElement(stack);
        reverseStack(stack);
        stack.push(i);
    }

    public int getAndRemoveStackLastElement(Stack<Integer> stack){
        int result = stack.peek();
        stack.pop();
        if(stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveStackLastElement(stack);
            stack.push(result);
            return last;
        }
    }


}
