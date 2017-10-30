import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i : s.p1(new int[] {462, 1268, 0, 4, 6, 9, 8})) System.out.print(i + " ");
        System.out.println();
        for (int i : s.p2(Arrays.asList(new String[]{"aabc", "abcd"}, new String[]{"ahahah", "aanannananna"}))) System.out.print(i + " ");
        System.out.println();
        System.out.println(s.p3(Arrays.asList(new int[]{2,3}, new int[]{3,7}, new int[]{4,1})));
        for (String t : s.p4(Arrays.asList("1/2+1/3", "+1/3+1/6", "-3/2+1/7", "0/1+0/10"))) System.out.print(t + " ");
    }
    public int[] p1(int[] nums) {
        int[] count = new int[] { 1, 0, 0, 0, 1, 0, 1, 0, 2, 1 };
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            char[] cs = (nums[i] + "").toCharArray();
            for (char c : cs) s += count[c - '0'];
            res[i] = s;
        }
        return res;
    }
    public List<Integer> p2(List<String[]> input) {
        List<Integer> res = new ArrayList<>();
        for (String[] pair : input) {
            int[] count = new int[256];
            for (int i = 0; i < pair[0].length(); i++) {
                count[pair[0].charAt(i)]++;
                count[pair[1].charAt(i)]--;
            }
            int s = 0;
            for (int i : count) {
                if (i > 0) s += i;
            }
            res.add(s);
        }
        return res;
    }
    public int p3(List<int[]> strs) {
        if (strs.size() == 0) return 0;
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for (int[] pair : strs) {
            x = Math.min(x, pair[0]);
            y = Math.min(y, pair[1]);
        }
        return x * y;
    }
    class Frac {
        int n;
        int d;
        public Frac(int n, int d) {
            int g = gcd(n, d);
            this.n = n / g;
            this.d = d / g;
        }
        public void add(Frac o) {
            n = o.d * n + o.n * d;
            d = d * o.d;
            int r = gcd(n, d);
            n /= r;
            d /= r;
        }
        private int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b != 0) {
                int tmp = a;
                a = b;
                b = tmp % b;
            }
            return a;
        }
        @Override
        public String toString() {
            return n + "/" + d;
        }
    }
    public List<String> p4(List<String> strs) {
        List<String> res = new ArrayList<>();
        for (String s : strs) {
            Frac f = null;
            for (int i = 0, start = 0; i < s.length(); i++) {
                while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-') i++;
                if (i != start) {
                    Frac curr = parseFrac(s.substring(start, i));
                    if (f == null) f = curr;
                    else f.add(curr);
                }
                start = i;
            }
            res.add(f.toString());
        }
        return res;
    }
    private Frac parseFrac(String s) {
        String[] ps = s.split("/");
        return new Frac(Integer.parseInt(ps[0]), Integer.parseInt(ps[1]));

    }
}
