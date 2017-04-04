public class NextGreaterElement {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (found && nums[j] > findNums[i]) {
                    res[i] = nums[j];
                    found = false;
                    break;
                } else if (nums[j] == findNums[i]) {
                    found = true;
                }
            }
            if (found) res[i] = -1;
        }
        return res;
    }
}
