public class FourKeysKeyboard {
    public int maxA(int N) {
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) dp[i] = i + 1;
        for (int i = 0; i < N; i++) {
            for (int j = i + 3; j < N; j++) {
                dp[j] = Math.max(dp[j], dp[i] * (j - i - 1));
            }
        }
        return dp[N - 1];
    }
}
