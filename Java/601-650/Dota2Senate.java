class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int count = 1;
        char c = senate.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < senate.length(); i++) {
            if (senate.charAt(i) == c) {
                count++;
                sb.append(c);
            } else {
                count--;
            }
            if (count == 0) {
                return predictPartyVictory(senate.substring(i + 1) + c + sb.toString());
            }
        }
        return winner(c);
    }
    String winner(char c) {
        if (c == 'R') return "Radiant";
        return "Dire";
    }
}
