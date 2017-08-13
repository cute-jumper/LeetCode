public class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0, up = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') up++;
            else if (c == 'D') up--;
            else if (c == 'L') left++;
            else if (c == 'R') left--;
        }
        return up == 0 && left == 0;
    }
}
