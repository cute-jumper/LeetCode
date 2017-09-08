public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);
        int minSum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            String name = list2[i];
            if (map.containsKey(name) && map.get(name) + i <= minSum) {
                if (map.get(name) + i < minSum) {
                    minSum = map.get(name) + i;
                    res.clear();
                }
                res.add(name);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
