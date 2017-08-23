public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> numList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) numList.add(nums[i] + "");
        Collections.sort(numList, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return (b + a).compareTo(a + b);
                }
            });
        if (numList.isEmpty() || numList.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String i : numList) sb.append(i);
        return sb.toString();
    }
}
