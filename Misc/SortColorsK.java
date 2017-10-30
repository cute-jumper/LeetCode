import java.util.*;

public class SortColorsK {
    public static void main(String[] args) {
        SortColorsK s = new SortColorsK();
        print(s.sort(new int[] { 3, 2, 3, 1, 1, 2, 2, 3}));
        print(s.sort(new int[] { 1, 1, 2, 1 }));
    }
    int[] sort(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] > 0) {
                int v = nums[i] - 1;
                if (nums[v] <= 0) {
                    nums[v]--;
                    nums[i] = 0;
                    i++;
                } else {
                    nums[i] = nums[v];
                    nums[v] = -1;
                }
            } else {
                i++;
            }
        }
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 0) {
                for (int j = 0; j > nums[i]; j--) {
                    nums[index--] = i + 1;
                }
            }
        }
        return nums;
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
