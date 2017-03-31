public class Solution {
    int[] copy;
    int[] original;
    Random rand = new Random();

    public Solution(int[] nums) {
        this.copy = new int[nums.length];
        this.original = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = original[i] = nums[i];
        }

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < copy.length; i++) {
            int index = i + rand.nextInt(copy.length - i);
            if (index != i) {
                int tmp = copy[index];
                copy[index] = copy[i];
                copy[i] = tmp;
            }
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
