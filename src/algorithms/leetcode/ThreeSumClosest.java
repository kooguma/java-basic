package algorithms.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public int solution(int[] nums, int target) {

        //边界条件
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        //不必是 length-2
        for (int left = 0; left < nums.length - 2; left++) {
            int tmp = target - nums[left];
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                if (Math.abs(tmp - nums[mid] - nums[right]) < Math.abs(target - min))
                    min = nums[left] + nums[mid] + nums[right];
                if (nums[mid] + nums[right] == tmp) {
                    // 只有一种答案
                    return target;
                } else if (nums[mid] + nums[right] < tmp)
                    mid++;
                else
                    right--;
            }
        }
        return min;
    }
}
