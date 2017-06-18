public class SnakeGame {
    int[][] food;
    int currFood;
    int width;
    int height;
    int x, y;
    Deque<int[]> queue = new ArrayDeque<>();

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        queue.offer(new int[] { 0, 0 });
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch (direction.charAt(0)) {
            case 'U': {
                y--;
                break;
            }
            case 'L': {
                x--;
                break;
            }
            case 'R': {
                x++;
                break;
            }
            default: {
                y++;
                break;
            }
        }
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return -1;
        }
        int[] head = new int[] { y, x };
        if (currFood < food.length && y == food[currFood][0] && x == food[currFood][1]) {
            queue.offerFirst(head);
            return ++currFood;
        }
        int[] tail = queue.pollLast();
        for (int[] p : queue) {
            if (p[0] == head[0] && p[1] == head[1]) return -1;
        }
        queue.offerFirst(head);
        return currFood;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
