package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode 448
public class FindAllNumbersDisappearedInAnArray {


    /**
     *  1 2 3 4 5 6 7 8
     *  0 1 2 3 4 5 6 7
     *
     *  [4.3.2.7.8.2.3.1]
     * -->
     *  [3.2.1.6.7.1.2.0] marks nums[index] as negative
     * -->
     * [-4.-3.-2.-7.8.2.-3.-1]
     */
    public static List<Integer> solution(int[] nums){
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
