class Sticker2SpellWord {
    public int minStickers(String[] stickers, String target) {
        int[] dp = new int[1 << target.length()];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == -1) continue;
            for (String s : stickers) {
                int next = i;
                for (int j = 0; j < s.length(); j++) {
                    for (int k = 0; k < target.length(); k++) {
                        if (((next >> k) & 1) == 0 && target.charAt(k) == s.charAt(j)) {
                            next |= 1 << k;
                            break;
                        }
                    }
                }
                if (dp[next] == -1 || dp[next] > dp[i] + 1) dp[next] = dp[i] + 1;
            }
        }
        return dp[dp.length - 1];
    }
}
