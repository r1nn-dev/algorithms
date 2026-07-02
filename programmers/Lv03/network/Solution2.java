// Solution2: BFS 방식

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터라면 새로운 네트워크이다.
            if (!visited[i]) {
                bfs(i, n, computers, visited);
                count++;
            }
        }

        return count;
    }

    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();

        // 시작 컴퓨터를 방문 처리하고 큐에 넣는다.
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 컴퓨터와 연결된 모든 컴퓨터를 확인한다.
            for (int next = 0; next < n; next++) {
                // 연결되어 있고 아직 방문하지 않았다면 같은 네트워크에 속한다.
                if (computers[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
