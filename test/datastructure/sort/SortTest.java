package datastructure.sort;

import algorithms.sort.ShellSort;
import org.junit.Test;

public class SortTest {

    private final static Integer[] SHELL_SORT_TEST = new Integer[]{50,26,38,80,70,90,8,30,40,20};

    @Test
    public void shellSortTest(){
        ShellSort.shellSort(SHELL_SORT_TEST);
    }
}
