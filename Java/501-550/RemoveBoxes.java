public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        if (boxes.length == 0) return 0;
        int[][][] memo = new int[boxes.length][boxes.length][boxes.length];
        return dfs(memo, boxes, 0, boxes.length - 1, 0);
    }
    public int dfs(int[][][] memo, int[] boxes, int l, int r, int k) {
        if (l > r) return 0;
        if (memo[l][r][k] != 0) return memo[l][r][k];
        while (r > l && boxes[r] == boxes[r-1]) {
            r--;
            k++;
        }
        int maxVal = dfs(memo, boxes, l, r - 1, 0) + (k + 1) * (k + 1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                maxVal = Math.max(maxVal, dfs(memo, boxes, l, i, k + 1) + dfs(memo, boxes, i + 1, r - 1, 0));
            }
        }
        memo[l][r][k] = maxVal;
        return maxVal;
    }
}
