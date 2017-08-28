public class VerifyPreorderOfBST {
    public boolean isValidSerialization(String preorder) {
        int[] stack = new int[preorder.length()];
        int top = -1;
        String[] nodes = preorder.split(",");
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("#")) {
                while (top >= 0 && stack[top]++ == 1) stack[top--] = 0;
                if (top == -1) return i == nodes.length - 1;
            } else {
                top++;
            }
        }
        return top == -1;
    }
}
