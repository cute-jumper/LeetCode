public class VerifyPreorderSequenceInBST {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int low = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            int v = preorder[i];
            if (v < low) return false;
            while (!stack.isEmpty() && stack.peek() < v) low = stack.pop();
            stack.push(v);
        }
        return true;
    }
}
