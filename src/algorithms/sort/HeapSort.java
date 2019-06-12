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
        //左孩子
        int lc = 2 * i + 1;
        //右孩子
        int rc = 2 * i + 2;
        //最大下标
        int max = i;

        if (lc < n && nums[max] < nums[lc]) {
            max = lc;
        }

        if (rc < n && nums[max] < nums[rc]) {
            max = rc;
        }

        if (max != i) {
            //交换
            int tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
            //向下调整
            heapify(nums, n, max);
        }
    }

    //建堆
    private static void buildHeap(int nums[], int n) {
        //最后一个元素
        int last = n - 1;
        //最后一个元素的父元素
        int parent = (last - 1) / 2;
        //从最后一个元素的夫元素开始建堆
        for (int i = parent; i >= 0; i--) { // [parent,0]
            heapify(nums, n, i);
        }
    }

}
