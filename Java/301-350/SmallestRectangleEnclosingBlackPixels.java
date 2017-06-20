public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0 || image[0].length == 0) return 0;
        int left = search(image, false, 0, y, false);
        int right = search(image, true, y, image[0].length - 1, false);
        int top = search(image, false, 0, x, true);
        int bottom = search(image, true, x, image.length - 1, true);
        return (bottom - top + 1) * (right - left + 1);
    }
    int search(char[][] image, boolean dir, int low, int high, boolean rowWise) {
        while (low < high) {
            int mid = low + (high - low + (dir ? 1 : 0)) / 2;
            boolean found = false;
            int size = rowWise ? image[mid].length : image.length;
            for (int i = 0; i < size; i++) {
                char c = rowWise ? image[mid][i] : image[i][mid];
                if (c == '1') {
                    found = true;
                    break;
                }
            }
            if (found) {
                if (dir) low = mid;
                else high = mid;
            } else {
                if (dir) high = mid - 1;
                else low = mid + 1;
            }
        }
        return high;
    }
}
