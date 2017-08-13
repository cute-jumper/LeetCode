public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int index = Collections.binarySearch(arr, x);
        int left, right;
        if (index < 0) {
            left = -index - 2;
            right = -index - 1;
        } else {
            left = index;
            right = index + 1;
        }
        while (k > 0) {
            if (left < 0) right++;
            else if (right >= arr.size()) left--;
            else {
                if (x - arr.get(left) <= arr.get(right) - x) left--;
                else right++;
            }
            k--;
        }
        return arr.subList(left + 1, right);
    }
}
