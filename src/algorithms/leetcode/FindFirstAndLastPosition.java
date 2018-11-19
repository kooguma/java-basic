package algorithms.leetcode;

//34
public class FindFirstAndLastPosition {

    //log(n)
    public int[] solution(int[] nums, int target) {
        //极限条件
        if (nums == null || nums.length == 0)
            return new int[]{-1, 1};

        int st = 0, ed = nums.length - 1, mid;

        //左边界
        while (st < ed) {
            //mid左偏
            mid = st + (ed - st) / 2;
            if (nums[mid] < target)
                st = mid + 1;
            else
                ed = mid;
        }

        //左边届不存在，那么右边界也不存在
        if (nums[st] != target)
            return new int[]{-1, -1};

        //右边届
        while (st < ed) {
            //mid右偏
            mid = st + (ed - st) / 2 + 1;
            if (nums[mid] > target)
                ed = mid - 1;
            else
                ed = mid;
        }

        if (nums[ed] != target)
            return new int[]{st, -1};

        return new int[]{st, ed};
    }
}
