import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int low = 0, high = height.length - 1;
        int maxValue = 0;
        while (low < high) {
            maxValue = Math.max(maxValue, Math.min(height[low], height[high]) * (high - low));
            if (height[low] > height[high]) {
                high--;
            } else {
                low++;
            }
        }
        return maxValue;
    }

}
