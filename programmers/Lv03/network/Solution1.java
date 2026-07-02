// Solution1: DFS 방식

class Solution {
    private boolean[] visited;
    private int[][] computers;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.visited = new boolean[n];

        int count = 0;

        // 모든 컴퓨터를 하나씩 확인한다.
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터라면 새로운 네트워크이다.
            if (!visited[i]) {
                dfs(i, n);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, int n) {
        // 현재 컴퓨터를 방문 처리한다.
        visited[node] = true;

        // 현재 컴퓨터와 연결된 모든 컴퓨터를 확인한다.
        for (int next = 0; next < n; next++) {
            // 연결되어 있고 아직 방문하지 않았다면 같은 네트워크에 속한다.
            if (computers[node][next] == 1 && !visited[next]) {
                dfs(next, n);
            }
        }
    }
}
