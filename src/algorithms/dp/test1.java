package algorithms.dp;

import java.io.*;
import java.util.*;

public class test1 {
    public static void main(String args[]) {

        Scanner cin = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        while (cin.hasNext()){
            inputs.add(cin.nextLine());
        }

        for (String input : inputs){
          System.out.println(result(input));
        }

    }

    public static String result(String input){
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int n = 0;

        for (char c : input.toCharArray()) {

            if (c == '[') {
                stack.push(c);

            }

            if (c == ']') {
                sb.setLength(0);
                res.setLength(0);
                char s;
                while ((s = stack.pop()) != '[') {
                    sb.append(s);
                }
                s = stack.pop();
                n = s - 48;
                String tmp = sb.reverse().toString();
                for(int i = 0 ; i < n ; i++){
                    res.append(tmp);
                }
                for(char a : res.toString().toCharArray()){
                    stack.push(a);
                }
                continue;
            }

            if (Character.isDigit(c)) {
                stack.push(c);
            }

            if (Character.isAlphabetic(c)) {
                stack.push(c);
            }
        }

        StringBuilder s = new StringBuilder();

        while (!stack.isEmpty()){
            s.append(stack.pop());
        }


        return s.reverse().toString();
    }
}
               