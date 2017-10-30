import java.util.*;
public class SwapOnce {
    public static void main(String[] args) {
        SwapOnce swap = new SwapOnce();
        print(swap.swapOnce(new int[] { 4, 1, 2, 4 }));
        print(swap.swapOnce(new int[] { 4, 4, 1, 2 }));
        print(swap.swapOnce(new int[] { 4, 4, 2, 1 }));
        print(swap.swapOnce(new int[] { 4, 3, 1, 2, 5 }));
    }
    int[] swapOnce(int[] nums) {
        return swapOnce(nums, 0);
    }
    int[] swapOnce(int[] nums, int start) {
        if (start == nums.length) return nums;
        int maxIndex = -1;
        for (int i = start; i < nums.length; i++) {
            if (maxIndex == -1 || nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = start; i < maxIndex; i++) {
            if (nums[i] < nums[maxIndex]) {
                swap(nums, i, maxIndex);
                return nums;
            }
        }
        return swapOnce(nums, maxIndex + 1);
    }
    static void print(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) res.add(i);
        System.out.println(res);
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
