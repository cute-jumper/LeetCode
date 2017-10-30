public class SplitArrayLargestSum {
    public static void main(String[] args) {
        SplitArrayLargestSum obj = new SplitArrayLargestSum();
        System.out.println(obj.getLargest(new int[] { 0,1,4,3,8,2,4,1,1,2,5}));
        System.out.println(obj.getLargest(new int[] { 0,1,4,3,8,2,3,12,1,2,9}));
        System.out.println(obj.getLargest(new int[] { 0,1,1,0,0,0,4,8,2,3,12,1,2,9}));
    }
    public int getLargest(int[] nums) {
        int[] dp = new int[nums.length];
        int mid = 0, s = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            while (index <= i && Math.abs(s - mid * 2) >= Math.abs(s - 2 * (mid + nums[index]))) mid += nums[index++];
            dp[i] = Math.max(mid, s - mid);
        }
        int min = Integer.MAX_VALUE;
        s = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            s += nums[i];
            System.out.println(i + ": " + dp[i] + " " + s);
            min = Math.min(min, Math.max(dp[i - 1], s));
        }
        return min;
    }
}
