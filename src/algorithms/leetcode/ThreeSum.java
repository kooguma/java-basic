package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static class Tuple {
        int a;
        int b;
        int c;

        public Tuple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof Tuple) {
                Tuple tuple = (Tuple) object;
                return tuple.a == this.a && tuple.b == this.b && tuple.c == this.c;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(new int[]{a, b, c});
        }
    }

    //三重循环 O(n^3)
    public static List<Tuple> solution1(int[] nums) {
        List<Tuple> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Tuple tuple = new Tuple(nums[i], nums[j], nums[k]);
                        if (!results.contains(tuple)) {
                            results.add(tuple);
                        }
                    }
                }
            }
        }
        return results;
    }

    public static List<List<Integer>> solution2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list;
        list = new ArrayList<List<Integer>>();
        int mid, right;
        //left只用循环所有的非正数就行了（不是负数是因为还要考虑[0 0 0]的情况所以是非正数）
        for (int left = 0; left < nums.length && nums[left] <= 0; left++) {
            mid = left + 1;
            right = nums.length - 1;
            int tmp = 0 - nums[left];
            //跳过left重复匹配
            if (left > 0 && nums[left] == nums[left - 1])
                continue;
            while (mid < right) {
                if (nums[mid] + nums[right] == tmp) {
                    int tmp_mid = nums[mid], tmp_right = nums[right];
                    list.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    //跳过right和mid的重复匹配
                    while (mid < right && nums[++mid] == tmp_mid) ;
                    while (mid < right && nums[--right] == tmp_right) ;
                } else if (nums[mid] + nums[right] < tmp)
                    mid++;
                else
                    right--;
            }
        }
        return list;
    }
}
