public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> w2i = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            w2i.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            sb = sb.reverse();
            StringBuilder pref = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                pref.append(words[i].charAt(j));
                sb.deleteCharAt(sb.length() - 1);
                if (isPalindrome(pref.toString()) && w2i.containsKey(sb.toString())) {
                    if (w2i.get(sb.toString()) == i) continue;
                    List<Integer> pair = new ArrayList<>();
                    pair.add(w2i.get(sb.toString()));
                    pair.add(i);
                    res.add(pair);
                    if (sb.toString().length() == 0) {
                        pair = new ArrayList<Integer>(pair);
                        Collections.reverse(pair);
                        res.add(pair);
                    }
                }
                pref = pref.reverse();
                if (isPalindrome(sb.toString()) && w2i.containsKey(pref.toString())) {
                    if (w2i.get(pref.toString()) == i) continue;
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(w2i.get(pref.toString()));
                    res.add(pair);
                }
                pref = pref.reverse();
            }
        }
        return res;
    }
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high && s.charAt(low) == s.charAt(high)) {
            low++;
            high--;
        }
        return low >= high;
    }
}
