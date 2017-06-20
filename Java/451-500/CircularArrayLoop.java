public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = i;
            boolean hasLoop = true;
            do {
                int next = getNext(nums, slow);
                if (nums[slow] * nums[next] <= 0) {
                    hasLoop = false;
                    break;
                }
                slow = next;
                fast = getNext(nums, getNext(nums, fast));
            } while (slow != fast);
            if (hasLoop && slow != getNext(nums, slow)) return true;
            slow = i;
            while (nums[slow] != 0) {
                int next = getNext(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }
    int getNext(int[] nums, int i) {
        int n = i + nums[i];
        if (n < 0) return nums.length + n;
        else return n % nums.length;
    }
}
