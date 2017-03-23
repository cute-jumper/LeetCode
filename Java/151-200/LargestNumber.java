public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        Collections.sort(numList, new Comparator<Integer>() {
               @Override
               public int compare(Integer a, Integer b) {
                   String as = a + "" + b;
                   String bs = b + "" + a;
                   return bs.compareTo(as);
               }
            });
        StringBuilder sb = new StringBuilder();
        if (numList.size() > 1 && numList.get(0) == 0 &&
            numList.get(numList.size() - 1) == 0)
            return "0";
        for (Integer i : numList) {
            sb.append(i);
        }
        return sb.toString();
    }
}
