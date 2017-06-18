public class SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int min = Integer.MAX_VALUE;
        int total = 0;
        for (int[] nut : nuts) {
            int s = getDistance(squirrel, nut);
            int t = getDistance(tree, nut);
            min = Math.min(min, s - t);
            total += t * 2;
        }
        return total + min;
    }
    int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
