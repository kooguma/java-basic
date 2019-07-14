package algorithms.sort;

public class QuickSort {

    //对于很小的数组快速排序不如插入排序
    private static final int CUTOFF = 10;

    public static <T extends Comparable<? super T>> void quickSort(T[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);
            int i = left, j = right;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) ;
                while (a[--j].compareTo(pivot) > 0) ;
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            //restore pivot
            swapReferences(a, i, right - 1);

            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);

        } else {
            //insertionSort(a,left,right);
        }
    }

    //3数中指分割法
    public static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0)
            swapReferences(a, left, center);
        if (a[right].compareTo(a[left]) < 0)
            swapReferences(a, right, left);
        if (a[right].compareTo(a[center]) < 0)
            swapReferences(a, right, center);

        //place pivot at right-1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    public static <T extends Comparable<? super T>> void swapReferences(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
