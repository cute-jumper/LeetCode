public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            if (i == heights.length || !stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int lowRight = i == heights.length ? 0 : heights[i];
                while (!stack.isEmpty() && heights[stack.peek()] > lowRight) {
                    int h = heights[stack.pop()];
                    int indexLeft = stack.isEmpty() ? -1 : stack.peek();
                    maxArea = Math.max(maxArea, h * (i - indexLeft -1));
                }
            }
            if (i < heights.length) stack.push(i);
        }
        return maxArea;
    }
}
