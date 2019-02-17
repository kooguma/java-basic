package algorithms.leetcode;

public class MedianOfTwoSortedArrays {

    public static double solution(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return solution(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                //cut1 左移，使更多的元素被分配到右边
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                //cut1 右移，使更多的元素被分配到左边
                cutL = cut1 + 1;
            } else {
                if (len % 2 == 0) {
                    //偶数
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                } else {
                    R1 = R1 < R2 ? R1 : R2;
                    return R1;
                }
            }
        }
        return -1;
    }

}
