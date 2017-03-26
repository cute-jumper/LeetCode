/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int firstBad = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                firstBad = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return firstBad;
    }
}
