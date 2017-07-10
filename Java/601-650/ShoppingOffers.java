public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = Integer.MAX_VALUE;
        for (List<Integer> offer : special) {
            boolean fit = true;
            for (int i = 0; i < needs.size(); i++) {
                needs.set(i, needs.get(i) - offer.get(i));
                if (needs.get(i) < 0) fit = false;
            }
            if (fit) {
                res = Math.min(res, offer.get(needs.size()) + shoppingOffers(price, special, needs));
            }
            for (int i = 0; i < needs.size(); i++) {
                needs.set(i, needs.get(i) + offer.get(i));
            }
        }
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        res = Math.min(res, total);
        return res;
    }
}
