public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) set.add(i);
        if (set.size() > candies.length / 2) return candies.length / 2;
        return set.size();
    }
}
