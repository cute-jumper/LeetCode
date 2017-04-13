public class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int i = 0;
        int j = 0;
        int count = 0;
        int prev = -1;
        int start1 = -1, count1 = 0;
        int repeat = n1;
        while (repeat > 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
            if (i == s1.length()) {
                repeat--;
                i = 0;
            }
            if (j == s2.length()) {
                count++;
                j = 0;
                if (prev == -1) {
                    prev = i;
                    count1 = count;
                    start1 = repeat;
                } else if (prev == i) {
                    int diff = start1 - repeat;
                    int increase = count - count1;
                    int times = (repeat - 1) / diff;
                    repeat -= times * diff;
                    count += increase * times;
                    prev = -2;
                }
            }
        }
        return count / n2;
    }
}
