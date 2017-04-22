public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int low = 0;
        int prev = ratings[0];
        int current = 1;
        int total = 1;
        int lowVal = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > prev) {
                current++;
                low = i;
                lowVal = current;
            } else if (ratings[i] < prev) {
                if (current == 1) {
                    total += i - low - 1;
                    if (lowVal > 1) lowVal--;
                    if (lowVal <= 1) total++;
                } else {
                    current = 1;
                }
            } else {
                low = i;
                lowVal = 0;
                current = 1;
            }
            total += current;
            prev = ratings[i];
        }
        return total;
        // if (ratings.length == 0) return 0;
        // int[] candies = new int[ratings.length];
        // int current = 1;
        // for (int i = 0; i < ratings.length; i++) {
        //     if (i == 0 || ratings[i] <= ratings[i-1]) {
        //         candies[i] = current = 1;
        //     } else {
        //         candies[i] = ++current;
        //     }
        // }
        // int total = candies[ratings.length - 1];
        // for (int i = ratings.length - 1; i >= 1; i--) {
        //     if (ratings[i-1] > ratings[i]) {
        //         candies[i-1] = Math.max(candies[i-1], candies[i] + 1);
        //     }
        //     total += candies[i-1];
        // }
        // return total;
    }
}
