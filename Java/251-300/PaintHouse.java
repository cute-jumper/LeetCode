public class PaintHouse {
    public int minCost(int[][] costs) {
        int red = 0, blue = 0, green = 0;
        for (int[] cost : costs) {
            int prevRed = red;
            red = Math.min(blue, green) + cost[0];
            int prevBlue = blue;
            blue = Math.min(prevRed, green) + cost[1];
            green = Math.min(prevRed, prevBlue) + cost[2];
        }
        return Math.min(Math.min(red, blue), green);
    }
}
