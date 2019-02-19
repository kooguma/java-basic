package algorithms.leetcode;

//MaxArea
public class ContainerWithMostWater {

    //O(n^2)
    public int solution1(int[] height) {
        int volMax = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int vol = (height[j] - height[i]) * (j - i);
                if (vol > volMax) volMax = vol;
            }
        }
        return volMax;
    }

    //O(n)
    public int solution2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int volMax = Math.min(height[l], height[r]) * (r - l);
        while (l < r) {
//            每次移动left和Right中间高度较小的（因为反正都是移动一
//            次，宽度肯定缩小1，这时候只能指望高度增加来增加容量，肯定是替换掉高度较小的，
//            才有可能找到更大的容量。）
            if (height[l] < height[r]) l++;
            else r--;
            int vol = Math.min(height[l], height[r]) * (r - l);
            if (vol > volMax) volMax = vol;
        }
        return volMax;
    }

}
