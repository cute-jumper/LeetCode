public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int w = (int)Math.floor(Math.sqrt(area));
        while (area % w != 0) {
            w--;
        }
        return new int[] { area / w, w };
    }
}
