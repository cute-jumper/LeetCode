public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> hours = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();
            genSeq(hours, 0, 4, i, 11);
            genSeq(minutes, 0, 6, num - i, 59);
            for (Integer h : hours) {
                for (Integer m : minutes) {
                    res.add(h + ":" + (m < 10 ? "0" + m : "" + m));
                }
            }
        }
        return res;
    }
    public void genSeq(List<Integer> nums, int curr, int remain, int k, int max) {
        if (k == 0) {
            if (curr <= max) nums.add(curr);
            return;
        }
        for (int i = k - 1; i < remain; i++) {
            genSeq(nums, curr | (1 << i), i, k - 1, max);
        }
    }
}
