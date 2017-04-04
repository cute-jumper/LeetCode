public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = Integer.MIN_VALUE;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index >= 0) {
                radius = Math.max(radius, 0);
            } else {
                index = -index - 1;
                int min = Integer.MAX_VALUE;
                if (index == heaters.length) min = house - heaters[index - 1];
                else if (index == 0) min = heaters[0] - house;
                else {
                    min = Math.min(house - heaters[index - 1], heaters[index] - house);
                }
                radius = Math.max(radius, min);
            }
        }
        return radius;
    }
}
