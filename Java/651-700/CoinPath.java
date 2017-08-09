public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] dp = new int[A.length];
        int[] next = new int[A.length];
        dp[A.length - 1] = A[A.length - 1];
        next[A.length - 1] = -1;
        for (int i = A.length - 2; i >= 0; i--) {
            dp[i] = next[i] = -1;
            if (A[i] == -1) continue;
            for (int j = i + 1; j < A.length && j <= i + B; j++) {
                if (dp[j] != -1 && (dp[i] == -1 || dp[j] + A[i] < dp[i])) {
                    dp[i] = dp[j] + A[i];
                    next[i] = j;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int i;
        for (i = 0; i != -1; i = next[i]) {
            res.add(i + 1);
        }
        if (res.get(res.size() - 1) == A.length) return res;
        return new ArrayList<>();
    }
}
