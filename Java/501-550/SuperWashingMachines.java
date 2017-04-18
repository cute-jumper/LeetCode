public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int i : machines) total += i;
        if (total % machines.length != 0) return -1;
        int average = total / machines.length;
        total = 0;
        int minMove = 0;
        for (int i : machines) {
            total += i - average;
            minMove = Math.max(Math.max(minMove, Math.abs(total)), i - average);
        }
        return minMove;
    }
}
