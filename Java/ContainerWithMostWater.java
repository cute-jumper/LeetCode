import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        TreeMap<Integer, ArrayList<Integer>> bucket = new TreeMap<>();
        for (int i = 0; i < height.length; i++) {
            if (bucket.containsKey(height[i])) {
                bucket.get(height[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                bucket.put(height[i], list);
            }
        }
        int maxAreaValue = 0;
        boolean[] flags = new boolean[height.length];
        int low = 0, high = height.length - 1;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : bucket.entrySet()) {
            int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
            for (Integer i : entry.getValue()) {
                if (i < minValue) {
                    minValue = i;
                }
                if (i > maxValue) {
                    maxValue = i;
                }
                flags[i] = true;
            }
            int area = entry.getKey() * Math.max(high - minValue, maxValue - low);
            if (area > maxAreaValue) {
                maxAreaValue = area;
            }
            while (low <= high && flags[low]) {
                low++;
            }
            while (low <= high && flags[high]) {
                high--;
            }
        }
        return maxAreaValue;
    }

}
