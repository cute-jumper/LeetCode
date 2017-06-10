public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int total = 0;
        int z = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) z++;
            else {
                if (z > 0) {
                    total += z / 2;
                }
                z = -1;
            }
        }
        if (z > 0) {
            total += (z + 1) / 2;
        }
        return total >= n;
    }
}
