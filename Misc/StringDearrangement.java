import java.util.*;

public class StringDearrangement {
    public List<String> dearrange(String s) {
        List<String> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        helper(res, cs, s.toCharArray(), "", new boolean[s.length()]);
        return res;
    }
    void helper(List<String> res, char[] cs, char[] orig, String prefix, boolean[] visited) {
        if (prefix.length() == cs.length) {
            res.add(prefix);
            return;
        }
        char prev = 0;
        for (int i = 0; i < cs.length; i++) {
            if (visited[i] || cs[i] == orig[prefix.length()] || cs[i] == prev) continue;
            visited[i] = true;
            helper(res, cs, orig, prefix + cs[i], visited);
            prev = cs[i];
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        StringDearrangement sd = new StringDearrangement();
        String t = "aabcdee";
        List<String> res = sd.dearrange(t);
        for (String s : res) {
            System.out.println(s);
            if (!isValid(s, t)) {
                System.out.println("Invalid!");
                break;
            }
        }
        System.out.println(new HashSet<>(res).size() == res.size());
    }
    public static boolean isValid(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) return false;
        }
        return true;
    }
}
