public class VerifyPreorderOfBST {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) return true;
        String[] nodes = preorder.split(",");
        int[] stack = new int[nodes.length];
        int top = -1;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("#")) {
                if (top < 0) return false;
                stack[top]++;
                while (stack[top] == 2) {
                    stack[top] = 0;
                    top--;
                    if (top == -1) {
                        return i == nodes.length - 1;
                    } else {
                        stack[top]++;
                    }
                }
            } else {
                top++;
            }
        }
        return top == -1;
    }
}
