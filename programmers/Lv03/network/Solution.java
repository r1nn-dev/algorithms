class Solution {
    boolean[] visited;
    int[][] computers;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {   // 아직 방문 안 한 노드 발견
                dfs(i, n);       // 연결된 컴포넌트 전체 탐색
                count++;         // 새 네트워크 발견
            }
        }
        return count;
    }

    private void dfs(int node, int n) {
        visited[node] = true;                               // 현재 노드 방문 처리
        for (int j = 0; j < n; j++) {
            if (computers[node][j] == 1 && !visited[j]) {   // 연결 & 미방문
                dfs(j, n);                                  // 재귀 탐색
            }
        }
    }
}
