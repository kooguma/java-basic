package datastructure.sort;

import algorithms.sort.HeapSort;
import algorithms.sort.ShellSort;
import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    private final static Integer[] SORT_TEST = new Integer[]{50,26,38,80,70,90,8,30,40,20};
    private final static int[] HEAP_SORT_TEST = new int[]{2,5,3,1,10,4};

    @Test
    public void shellSortTest(){
        ShellSort.shellSort(SORT_TEST);
    }

    @Test
    public void heapSortTest(){
        int[] actual = HeapSort.heapSort(HEAP_SORT_TEST);
        int[] expected = new int[]{1,2,3,4,5,10};
        Assert.assertArrayEquals(expected,actual);
    }
}
