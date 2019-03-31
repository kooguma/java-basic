package algorithms.leetcode;

public class SingleNumber {

    public static int solution(int[] nums){
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }

}
