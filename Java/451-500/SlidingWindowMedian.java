public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> minHeap = new TreeMap<>();
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>();
        double[] res = new double[nums.length - k + 1];
        int[] sizes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) add(maxHeap, nums[i], sizes, 0);
            else {
                if (nums[i - k] > maxHeap.lastKey()) remove(minHeap, nums[i - k], sizes, 1);
                else remove(maxHeap, nums[i - k], sizes, 0);
                if (maxHeap.size() == 0 || nums[i] > maxHeap.lastKey()) add(minHeap, nums[i], sizes, 1);
                else add(maxHeap, nums[i], sizes, 0);
            }
            if (i >= k - 1) {
                balance(maxHeap, minHeap, sizes);
                if (k % 2 == 1) res[i - k + 1] = maxHeap.lastKey();
                else res[i - k + 1] = ((double)maxHeap.lastKey() + minHeap.firstKey()) / 2.0;
            }
        }
        return res;
    }
    public int remove(TreeMap<Integer, Integer> map, int key, int[] sizes, int index) {
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) map.remove(key);
        sizes[index]--;
        return key;
    }
    public void add(TreeMap<Integer, Integer> map, int key, int[] sizes, int index) {
        if (!map.containsKey(key)) map.put(key, 0);
        map.put(key, map.get(key) + 1);
        sizes[index]++;
    }
    public void balance(TreeMap<Integer, Integer> maxHeap, TreeMap<Integer, Integer> minHeap, int[] sizes) {
        while (sizes[0] < sizes[1]) {
            add(maxHeap, remove(minHeap, minHeap.firstKey(), sizes, 1), sizes, 0);
        }
        while (sizes[0] > sizes[1] + 1) {
            add(minHeap, remove(maxHeap, maxHeap.lastKey(), sizes, 0), sizes, 1);
        }
    }
}
