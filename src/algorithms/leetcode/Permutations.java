package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode 46
public class Permutations {

    public static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        helper(nums,0,res);
        return res;
    }

    private static void helper(int[] nums, int start, List<List<Integer>> res) {
        if(start == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            res.add(list);
            return;
        }

        for(int i = start ; i < nums.length ; i++){
            swap(nums,start,i);
            helper(nums,start+1,res);
            swap(nums,i,start);
        }
    }

    private static void swap(int[] nums, int start, int i) {
        int tmp = nums[start];
        nums[start] = nums[i];
        nums[i] = tmp;
    }


}
