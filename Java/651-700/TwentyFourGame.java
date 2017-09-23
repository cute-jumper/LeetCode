class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) list.add(i);
        List<List<Integer>> ps = new ArrayList<>();
        permute(ps, list, new ArrayList<>(), new boolean[4]);
        for (List<Integer> p : ps) {
            List<Double> res = helper(p, 0, p.size() - 1);
            for (double i : res) {
                if (Math.abs(i - 24) < 0.0001) return true;
            }
        }
        return false;
    }
    void permute(List<List<Integer>> res, List<Integer> list, List<Integer> curr, boolean[] visited) {
        if (curr.size() == list.size()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0 ; i < list.size(); i++) {
            if (!visited[i]) {
                curr.add(list.get(i));
                visited[i] = true;
                permute(res, list, curr, visited);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
    List<Double> helper(List<Integer> nums, int start, int end) {
        if (start == end) {
            return Arrays.asList((double)nums.get(start));
        }
        List<Double> res = new ArrayList<>();
        for (int i = start; i < end; i++) {
            List<Double> ns = helper(nums, start, i);
            List<Double> ms = helper(nums, i + 1, end);
            for (double n : ns) {
                for (double m : ms) {
                    res.add(n + m);
                    res.add(n - m);
                    res.add(n * m);
                    if (m != 0) res.add(n / m);
                }
            }
        }
        return res;
    }
}
