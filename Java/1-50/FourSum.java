public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        return kSum(target, nums, 0, 4);
    }

    public List<List<Integer>> kSum(int sum, int[] nums, int start, int k) {
        if (k == 2) {
            return twoSum(sum, nums, start);
        }
        List<List<Integer>> ret = new ArrayList<>();
        int prev = nums[start] - 1;
        int end = nums.length - k + 1;
        for (int i = start; i < end; i++) {
            while (i < end && nums[i] == prev) {
                i++;
            }
            if (i == end) {
                break;
            }
            List<List<Integer>> large = new ArrayList<>();
            List<List<Integer>> small = kSum(sum - nums[i], nums, i + 1, k - 1);
            for (List<Integer> s : small) {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[i]);
                cur.addAll(s);
                large.add(cur);
            }
            ret.addAll(large);
            prev = nums[i];
        }
        return ret;
    }

    public List<List<Integer>> twoSum(int sum, int[] nums, int start) {
        List<List<Integer>> ret = new ArrayList<>();
        int low = start, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == sum) {
                List<Integer> twoInts = new ArrayList<>();
                twoInts.add(nums[low]);
                twoInts.add(nums[high]);
                ret.add(twoInts);
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
