public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int head = findHead(nums);
        if (head == 0) {
            reverseRange(nums, 0, nums.length - 1);
        } else {
            int nextIndex = nums.length - 1;
            for (int i = nextIndex; i >= head; i--) {
                if (nums[i] > nums[head - 1]) {
                    nextIndex = i;
                    break;
                }
            }
            int tmp = nums[nextIndex];
            nums[nextIndex] = nums[head - 1];
            nums[head - 1] = tmp;
            reverseRange(nums, head, nums.length - 1);
        }
    }
    public int findHead(int[] nums) {
        int prev = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < prev) {
                return i + 1;
            }
            prev = nums[i];
        }
        return 0;
    }
    public void reverseRange(int[] nums, int low, int high) {
        for (; low < high; low++, high--) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
        }
    }
}
