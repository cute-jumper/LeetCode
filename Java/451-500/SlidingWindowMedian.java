public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> minHeap = new TreeMap<>();
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>();
        double[] res = new double[nums.length - k + 1];
        int[] ns = new int[k];
        for (int i = 0; i < k; i++) ns[i] = nums[i];
        int mid1 = findKth(ns, (k - 1) / 2);
        int maxSize = 0;
        int minSize = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > mid1 || nums[i] == mid1 && maxSize == (k + 1) / 2) {
                add(minHeap, nums[i]);
                minSize++;
            } else {
                add(maxHeap, nums[i]);
                maxSize++;
            }
        }
        if (k % 2 == 1) res[0] = mid1;
        else res[0] = (mid1 + (long)minHeap.firstKey()) / 2.0;
        for (int i = 1; i < res.length; i++) {
            if (nums[i-1] > maxHeap.lastKey()) {
                remove(minHeap, nums[i-1]);
                minSize--;
            } else {
                remove(maxHeap, nums[i-1]);
                maxSize--;
            }
            int key = nums[i + k - 1];
            if (maxHeap.size() == 0 || key > maxHeap.lastKey()) {
                add(minHeap, key);
                minSize++;
            } else {
                add(maxHeap, key);
                maxSize++;
            }
            while (maxSize < minSize) {
                add(maxHeap, remove(minHeap, minHeap.firstKey()));
                minSize--;
                maxSize++;
            }
            while (maxSize > minSize + 1) {
                add(minHeap, remove(maxHeap, maxHeap.lastKey()));
                minSize++;
                maxSize--;
            }
            if (k % 2 == 1) res[i] = maxHeap.lastKey();
            else res[i] = ((long)maxHeap.lastKey() + minHeap.firstKey()) / 2.0;
        }
        return res;
    }
    public int remove(TreeMap<Integer, Integer> map, int key) {
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) map.remove(key);
        return key;
    }
    public void add(TreeMap<Integer, Integer> map, int key) {
        if (!map.containsKey(key)) map.put(key, 0);
        map.put(key, map.get(key) + 1);
    }
    public int findKth(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        int pIndex = partition(nums, low, high);
        while (pIndex != k) {
            if (pIndex > k) {
                high = pIndex - 1;
            } else {
                low = pIndex + 1;
            }
            pIndex = partition(nums, low, high);
        }
        return nums[k];
    }
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int index = low;
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }
        nums[high] = nums[index];
        nums[index] = pivot;
        return index;
    }
}
