public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int first = 0, second = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first) {
                count1++;
            } else if (nums[i] == second) {
                count2++;
            } else if (count1 == 0) {
                first = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                second = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first) count1++;
            if (nums[i] == second) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(first);
        if (count2 > nums.length / 3) res.add(second);
        return res;
    }
}
