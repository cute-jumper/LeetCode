public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }
        int nonMatch = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) nonMatch++;
        }
        if (nonMatch == 0) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            int c1 = s.charAt(i - p.length()) - 'a';
            count[c1]++;
            if (count[c1] == 0) {
                nonMatch--;
            } else if (count[c1] == 1){
                nonMatch++;
            }
            int c2 = s.charAt(i) - 'a';
            count[c2]--;
            if (count[c2] == 0) {
                nonMatch--;
            } else if (count[c2] == -1) {
                nonMatch++;
            }
            if (nonMatch == 0) res.add(i - p.length() + 1);
        }
        return res;
    }
}
