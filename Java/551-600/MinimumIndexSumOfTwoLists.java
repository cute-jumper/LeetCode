public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            String name = list2[i];
            if (map.containsKey(name)) {
                int sum = map.get(name) + i;
                if (sum == minSum) {
                    res.add(name);
                } else if (sum < minSum) {
                    minSum = sum;
                    res.clear();
                    res.add(name);
                }
            }
        }
        String[] arr = new String[res.size()];
        int index = 0;
        for (String s : res) {
            arr[index++] = s;
        }
        return arr;
    }
}
