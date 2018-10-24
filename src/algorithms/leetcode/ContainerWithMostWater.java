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
            if (height[l] < height[r]) l++;
            else r--;
            int vol = Math.min(height[l], height[r]) * (r - l);
            if (vol > volMax) volMax = vol;
        }
        return volMax;
    }

}
