package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> solution(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // i left mid right
        for (int i = 0; i < nums.length - 3; i++) {

            int target_i = target - nums[i];

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int left = i; left < nums.length - 2; left++) {

                int mid = left + 1;
                int right = nums.length - 1;
                int tmp = target_i - nums[left];

                if (left > i + 1 && nums[left] == nums[left - 1])
                    continue;

                while (mid < right) {
                    int tmp_mid = nums[mid];
                    int tmp_right = nums[right];

                    if (nums[left] + nums[mid] + nums[right] == tmp) {
                        result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                        //跳过right和mid的重复匹配
                        while (mid < right && nums[++mid] == tmp_mid) ;
                        while (mid < right && nums[--right] == tmp_right) ;
                    } else if (nums[mid] + nums[right] < tmp)
                        mid++;
                    else
                        right--;

                }
            }

        }
        return result;
    }
}
