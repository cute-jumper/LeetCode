import java.util.*;

class LISByOne {
    public static void main(String[] args) {
        LISByOne one = new LISByOne();
        System.out.println(one.lisByOne(new int[] {}));
        System.out.println(one.lisByOne(new int[] {1,2,4,3,5,6,7,-1,0}));
    }
    int lisByOne(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : nums) {
            if (map.containsKey(i - 1)) {
                map.put(i, map.get(i - 1) + 1);
                map.remove(i - 1);
            } else {
                map.put(i, 1);
            }
            max = Math.max(max, map.get(i));
        }
        return max;
    }
}
