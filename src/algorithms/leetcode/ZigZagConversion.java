package algorithms.leetcode;

public class ZigZagConversion {

    public static String solution(String text, int nRows) {

        if (nRows < 1) return text;

        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < text.length(); i++) {
            //步长 2*nRows - 2
            int index = i % (2 * nRows - 2);
            index = index < nRows ? index : 2 * nRows - 2 - index;
            sb[index].append(text.charAt(i));
        }


        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }

}
