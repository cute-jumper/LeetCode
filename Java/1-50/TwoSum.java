import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] < target) {
                low++;
            } else if (nums[low] + nums[high] > target) {
                high--;
            } else {
                int first = findIndex(copy, nums[low], -1);
                int second = findIndex(copy, nums[high], first);
                return new int[] { first, second };
            }
        }
        return null;
    }
    public int findIndex(int[] array, int elem, int except) {
        for (int i =  0; i < array.length; i++) {
            if (i != except && array[i] == elem) {
                return i;
            }
        }
        return -1;
    }
}
