public class TrappingRainWater {
    public int trap(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxLow = 0;
        int maxHigh = 0;
        int total = 0;
        while (low <= high) {
            if (height[low] >= height[high]) {
                if (height[high] > maxHigh) maxHigh = height[high];
                total += maxHigh - height[high];
                high--;
            } else {
                if (height[low] >= maxLow) maxLow = height[low];
                total += maxLow - height[low];
                low++;
            }
        }
        return total;
    }
}
