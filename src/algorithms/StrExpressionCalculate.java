package algorithms;

import java.util.Comparator;
import java.util.Stack;

/**
 * Created by lzz on 2017/3/25.
 * 计算字符串数学表达式的算法
 * 1.中缀表达式——>后缀表达式
 * 2.计算后缀表达式
 */
public class StrExpressionCalculate {

    private static final String EXPRESSION = "((3+2)*8+5+37*6)";

    enum SymbolEnum{
        PLUS('+', 0),
        SUB('-', 0),
        MULTI('*', 1),
        DIV('／', 1),;

        public final char c;
        public final int p;

        SymbolEnum(char c, int p) {
            this.c = c;
            this.p = p;
        }

        public static SymbolEnum fromChar(char c){
            switch (c){
                case '+':
                    return PLUS;
                case '-':
                    return SUB;
                case '*':
                    return MULTI;
                case '/':
                    return DIV;
                default:
                    return null;
            }
        }
    }

    public static void main() {
        //中缀转后缀
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < EXPRESSION.length(); i++) {
            char c = EXPRESSION.charAt(i);
            if (c >= '0' && c <= '9'){
                sb.append(c);
            }else {

                if(stack.size() == 0) {
                    stack.push(c);
                }

                if(SymbolEnum.fromChar(stack.peek()).p < SymbolEnum.fromChar(c).p ){
                    stack.push(c);
                    break;
                }else {
                    sb.append(c);
                }
            }
        }

    }

}
