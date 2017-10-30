import java.util.*;

public class MinMaxSubSets {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.countSubsets(new int[] { 1, 2, 3, 4 }, 6));
        System.out.println(test.countSubsets(new int[] { 1, 2, 3, 7 }, 5));
    }
    public int countSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        int count = 0;
        while (low < high) {
            int s = nums[low] + nums[high];
            if (s < k) {
                int len = high - low;
                count += (1 << len) - 1;
                low++;
            } else {
                high--;
            }
        }
        return count;
    }
}

