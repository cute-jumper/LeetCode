import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) return ret;
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            while (i < nums.length - 2 && nums[i] == prev) {
                i++;
            }
            if (i == nums.length - 2) {
                break;
            }
            ret.addAll(twoSum(-nums[i], nums, i + 1));
            prev = nums[i];
        }
        return ret;
    }

    public List<List<Integer>> twoSum(int sum, int[] nums, int start) {
        List<List<Integer>> ret = new ArrayList<>();
        int low = start, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == sum) {
                List<Integer> threeInts = new ArrayList<>();
                threeInts.add(-sum);
                threeInts.add(nums[low]);
                threeInts.add(nums[high]);
                ret.add(threeInts);
                int newLow = low + 1;
                while (newLow < high && nums[low] == nums[newLow]) {
                    newLow++;
                }
                low = newLow;
            } else if (nums[low] + nums[high] > sum) {
                high--;
            } else {
                low++;
            }
        }
        return ret;
    }
}
