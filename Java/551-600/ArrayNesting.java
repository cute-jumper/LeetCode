public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int maxSize = 0;
        int[] size = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (size[i] > 0) continue;
            int index = nums[i];
            List<Integer> idx = new ArrayList<>();
            idx.add(i);
            while (index != i && size[index] == 0) {
                index = nums[index];
                idx.add(index);
            }
            int s = idx.size() + size[index];
            for (Integer j : idx) {
                size[j] = s--;
            }
            if (size[i] > maxSize) maxSize = size[i];
        }
        return maxSize;
    }
}
