// Solution1: DFS 기반 승패 관계 탐색 (권장)

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;

        // winGraph[A]에는 A 선수가 이긴 선수들이 저장된다.
        List<Integer>[] winGraph = new ArrayList[n + 1];

        // loseGraph[B]에는 B 선수를 이긴 선수들이 저장된다.
        List<Integer>[] loseGraph = new ArrayList[n + 1];

        // 선수 번호가 1번부터 시작하므로 1부터 n까지 리스트를 초기화한다.
        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }

        // 경기 결과를 방향 그래프로 표현한다.
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            // winner는 loser를 이겼다.
            winGraph[winner].add(loser);

            // loser 입장에서는 winner에게 졌다.
            loseGraph[loser].add(winner);
        }

        // 각 선수마다 순위를 정확하게 알 수 있는지 확인한다.
        for (int player = 1; player <= n; player++) {
            boolean[] visitedWin = new boolean[n + 1];
            boolean[] visitedLose = new boolean[n + 1];

            // 자기 자신은 탐색 대상에서 제외하기 위해 방문 처리한다. 
            visitedWin[player] = true; 
            visitedLose[player] = true;
            
            // player가 이길 수 있는 선수 수
            int winCount = dfs(player, winGraph, visitedWin);

            // player를 이길 수 있는 선수 수
            int loseCount = dfs(player, loseGraph, visitedLose);

            // 나보다 낮은 선수 수 + 나보다 높은 선수 수가 n - 1이면
            // 모든 선수와의 상대적 관계를 알 수 있으므로 순위가 확정된다.
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int dfs(int player, List<Integer>[] graph, boolean[] visited) {
        int count = 0;

        // 현재 선수와 연결된 선수들을 탐색한다.
        for (int next : graph[player]) {
            if (!visited[next]) {
                visited[next] = true;

                // next 선수 1명을 카운트하고,
                // next를 통해 추가로 도달할 수 있는 선수들도 함께 카운트한다.
                count += 1 + dfs(next, graph, visited);
            }
        }

        return count;
    }
}
