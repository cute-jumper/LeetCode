public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        Arrays.sort(sums);
        for (int i = 0; i < sums.length; i++) {
            treeMap.put(sums[i], i + 1);
        }
        int count = 0;
        long s = 0;
        int[] bit = new int[sums.length + 1];
        add(bit, treeMap.get(0l));
        for (int i : nums) {
            s += i;
            Long k1 = treeMap.floorKey(s-lower);
            Long k2 = treeMap.floorKey(s-upper-1);
            if (k1 != null) {
                count += getSum(bit, treeMap.get(k1)) - (k2 == null ? 0 : getSum(bit, treeMap.get(k2)));
            }
            add(bit, treeMap.get(s));
        }
        return count;
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
