package algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // 双循环 O(n^2) O(1)
    public static int[] solution1(int[] sums, int target) {
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                if (sums[i] + sums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //借助HashMap找补 O(n) O(n) two-pass
    public static int[] solution2(int[] sums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sums.length; i++) {
            map.put(sums[i], i);
        }

        for (int i = 0; i < sums.length; i++) {
            int complement = target - sums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //借助HashMap找补 O(n) O(n) one-pass
    public static int[] sulition3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
