package algorithms.leetcode;

public class RemoveDuplicatesFromSortedArray {

    //length<2  i-1
    public static int solution(int[] nums) {
        if (nums.length < 2) return nums.length;
        int newlen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) nums[newlen++] = nums[i];
        }
        return newlen;
    }
}
