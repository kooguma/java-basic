package algorithms.nowcoder;

public class SortedArrayContainsTarget {


    /***
     *
     *     1   2   3
     *     4   5   6
     *     7   8   9
     *
     *  从右上角开始找
     *  1.array[row][col] > k 往小了找，col--
     *  2.array[row][col] < k 往大了找，row++
     */
    public int[][] solution(int[][] array, int k) {
        int row = 0;
        int col = array[0].length;
        while (row < array.length && col > -1) {
            if (array[row][col] > k) {
                col--;
            } else if (array[row][col] < k) {
                row++;
            } else {
                return new int[][]{{row, col}};
            }
        }
        return null;
    }
}
