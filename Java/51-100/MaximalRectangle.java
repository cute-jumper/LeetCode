public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < heights.length; j++) {
                if (j < matrix[0].length) {
                    if (matrix[i][j] == '1') {
                        heights[j]++;
                    } else {
                        heights[j] = 0;
                    }
                }
                while (!stack.isEmpty() && heights[stack.peek()] > heights[j]) {
                    int h = heights[stack.pop()];
                    maxArea = Math.max(maxArea, h * (j - (stack.isEmpty() ? -1 : stack.peek()) - 1));
                }
                if (j < matrix[0].length) stack.push(j);
            }
        }
        return maxArea;
    }
}
