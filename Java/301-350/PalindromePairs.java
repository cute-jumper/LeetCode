public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> w2i = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            w2i.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                String p = words[i].substring(0, j);
                String q = words[i].substring(j);
                if (isPalindrome(p)) {
                    String qr = new StringBuilder(q).reverse().toString();
                    if (w2i.containsKey(qr) && w2i.get(qr) != i) {
                        res.add(Arrays.asList(w2i.get(qr), i));
                        if (qr.equals("")) res.add(Arrays.asList(i, w2i.get(qr)));
                    }
                }
                if (isPalindrome(q)) {
                    String pr = new StringBuilder(p).reverse().toString();
                    if (w2i.containsKey(pr) && w2i.get(pr) != i) {
                        res.add(Arrays.asList(i, w2i.get(pr)));
                    }
                }
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
