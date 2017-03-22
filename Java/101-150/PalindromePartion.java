public class PalindromePartion {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        getPartion(res, new ArrayList<String>(), s, 0);
        return res;
    }
    public void getPartion(List<List<String>> res, List<String> curr, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(curr));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (isPalindrome(sub)) {
                curr.add(sub);
                getPartion(res, curr, s, i);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
