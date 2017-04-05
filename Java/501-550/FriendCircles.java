public class FriendCircles {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            dfs(M, i, visited);
            res++;
        }
        return res;
    }
    public void dfs(int[][] M, int start, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < M.length; i++) {
            if (i != start && M[start][i] == 1 && !visited[i]) dfs(M, i, visited);
        }
    }
}
