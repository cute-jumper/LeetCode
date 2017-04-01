public class IntegerReplacement {
    public int integerReplacement(int n) {
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        if (n == 1) return count;
        return count + 2 + Math.min(integerReplacement((n - 1) / 2 + 1),
                                    integerReplacement((n - 1) / 2));
        // if (n < 3) return n - 1;
        // int old = n;
        // if (n % 2 == 1) n++;
        // int[] dp = new int[n];
        // dp[0] = 0;
        // dp[1] = 1;
        // for (int i = 2; i + 1 < n; i += 2) {
        //     dp[i + 1] = 1 + dp[i / 2];
        //     dp[i] = 1 + Math.min(dp[i - 1], dp[i + 1]);
        // }
        // if (n % 2 == 1) {
        //     dp[n - 1] = 1 + dp[n - 2];
        // }
        // return dp[old - 1];
    }
}
