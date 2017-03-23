public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '0') continue;
                traverse(grid, j, i);
                count++;
            }
        }
        return count;
    }

    public void traverse(char[][] grid, int x, int y) {
        int height = grid.length;
        int width = grid[0].length;
        if (x < 0 || x >= width || y < 0 || y >= height || grid[y][x] == '0') return;
        int[] vDirs = new int[] { -1, 0, 1, 0 };
        int[] hDirs = new int[] { 0, -1, 0, 1 };
        grid[y][x] = '0';
        for (int i = 0; i < 4; i++) {
            traverse(grid, x + hDirs[i], y + vDirs[i]);
        }

        // Deque<Integer> queue = new ArrayDeque<>();
        // queue.addFirst(start);
        // while (!queue.isEmpty()) {
        //     int curr = queue.removeLast();
        //     int i = curr / width;
        //     int j = curr % width;
        //     grid[i][j] = '0';
        //     for (int k = 0; k < 4; k++) {
        //         int x = j + hDirs[k];
        //         int y = i + vDirs[k];
        //         if (x >= 0 && x < width && y >= 0 && y < height &&
        //             grid[y][x] == '1') {
        //             queue.addFirst(y * width + x);
        //         }
        //     }
        // }
    }

}
