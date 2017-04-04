public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) < 2 * desiredTotal)
            return false;
        if (desiredTotal == 0) return true;
        return dfs(maxChoosableInteger, desiredTotal, 0, new HashMap<Integer, Boolean>());
    }
    public boolean dfs(int maxChoosableInteger, int desiredTotal, int chosen,
                       Map<Integer, Boolean> saved) {
        if (desiredTotal <= 0)  return false;
        if (saved.containsKey(chosen)) return saved.get(chosen);
        boolean win = false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (((chosen >>> (i - 1)) & 1) == 1) continue;
            if (!dfs(maxChoosableInteger, desiredTotal - i, chosen | (1 << (i - 1)), saved)) {
                win = true;
                break;
            }
        }
        saved.put(chosen, win);
        return win;
    }
}
