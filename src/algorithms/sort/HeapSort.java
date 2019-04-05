package algorithms.sort;

public class HeapSort {


    public static int[] heapSort(int nums[]) {
        int n = nums.length;
        buildHeap(nums, n);
        for (int i = n - 1; i >= 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            heapify(nums,i,0);
        }
        return nums;
    }


    //调整堆
    private static void heapify(int nums[], int n, int i) {
        if (i >= n) return;
        int lc = 2 * i + 1;
        int rc = 2 * i + 2;
        int max = i;

        if (lc < n && nums[max] < nums[lc]) {
            max = lc;
        }

        if (rc < n && nums[max] < nums[rc]) {
            max = rc;
        }

        if (max != i) {
            int tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
            heapify(nums, n, max);
        }
    }

    private static void buildHeap(int nums[], int n) {
        int last = n - 1;
        int parent = (last - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }

}
