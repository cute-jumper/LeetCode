public class TwoSum {

    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new LinkedHashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (!map.containsKey(number)) map.put(number, 1);
        else map.put(number, map.get(number) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = value - entry.getKey();
            if (key == entry.getKey() && entry.getValue() > 1 || key != entry.getKey() && map.containsKey(key)) return true;
        }
        return false;
    }
}
