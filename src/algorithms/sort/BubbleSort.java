package algorithms.sort;

public class BubbleSort {

    public static int[] solution1(int[] array) {
        int n = array.length;
        //从后往前两两比较相邻元素大小
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            //前一趟确定的最小元素不参与排序
            for (int j = n - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return array;
    }
}
