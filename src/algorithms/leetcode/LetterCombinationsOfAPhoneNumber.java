package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

//17 dfs
public class LetterCombinationsOfAPhoneNumber {

    private static final char[][] dict = new char[][]{
            {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public static List<String> solution(String digits) {


        List<String> result = new ArrayList<>();

        //boundary condition
        if (digits == null || digits.length() == 0) {
            return result;
        }

        appendCharacters(digits, result, 0, "");
        return result;
    }

    private static void appendCharacters(String digits, List<String> result, int index, String curStr) {
        //base case
        if (index == digits.length()) {
            result.add(curStr);
            return;
        }
        //recursive rule
        char[] values = dict[digits.charAt(index) - '1']; //下标减1
        for (char c : values) {
            appendCharacters(digits, result, index + 1, curStr + c);
        }
    }

}
