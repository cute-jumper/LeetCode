public class LastByte {
    public boolean isSingleByte(int[] nums) {
        int end = nums.length - 2;
        boolean res = true;
        while (end >= 0) {
            if (nums[end] <= 127) return res;
            res = !res;
            end--;
        }
        return res;
    }
    public int getType(int[] nums, int end) {
        if (end < 0) return 0;
        if (end == 0 || nums[end - 1] <= 127) {
            if (nums[end] <= 127) return 0;
            return 2;
        }
        if (getType(nums, end - 2) == 2) return 0;
        else return 1;
    }
    public static void main(String[] args) {
        LastByte lb = new LastByte();
        System.out.println(lb.isSingleByte(new int[] { 128, 128, 12 }));
        System.out.println(lb.isSingleByte(new int[] { 128, 127, 12 }));
        System.out.println(lb.isSingleByte(new int[] { 128, 12 }));
    }
}
