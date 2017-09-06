public class VerifyPreorderSequenceInBST {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, top = -1;
        for (int i = 0; i < preorder.length; i++) {
            int v = preorder[i];
            if (v < low) return false;
            while (top >= 0 && preorder[top] < v) low = preorder[top--];
            preorder[++top] = v;
        }
        return true;
    }
}
