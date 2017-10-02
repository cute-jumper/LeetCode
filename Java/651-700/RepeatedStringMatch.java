class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (B.charAt(j) != A.charAt((i + j) % A.length())) break;
                if (j == B.length() - 1) return (i + j) / A.length() + 1;
            }
        }
        return -1;
    }
}
