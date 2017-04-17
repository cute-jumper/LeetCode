public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];
        int[] copy = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++) copy[i] = nums[i];
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) map.put(copy[i], i + 1);
        int[] bit = new int[copy.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = map.get(nums[i]);
            count[i] = getSum(bit, index - 1);
            add(bit, index);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : count) res.add(i);
        return res;
    }
    public int lowBit(int x) {
        return x & (-x);
    }
    public void add(int[] bit, int i) {
        while (i < bit.length) {
            bit[i]++;
            i += lowBit(i);
        }
    }
    public int getSum(int[] bit, int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= lowBit(i);
        }
        return sum;
    }
}
