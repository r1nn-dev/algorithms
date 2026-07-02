// Solution1: 인접 리스트 + BFS 방식 

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 노드 번호가 1번부터 n번까지이므로 n + 1 크기의 인접 리스트를 만든다.
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선은 양방향이므로 양쪽 노드에 모두 연결 정보를 추가한다.
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 각 노드까지의 최단 거리를 저장한다.
        // -1은 아직 방문하지 않은 노드를 의미한다.
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        // 1번 노드에서 BFS를 시작한다.
        queue.offer(1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 노드와 연결된 모든 노드를 확인한다.
            for (int next : graph.get(current)) {
                // 아직 방문하지 않은 노드라면 최단 거리를 확정한다.
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
        }

        int maxDistance = 0;

        // 1번 노드에서 가장 먼 거리값을 찾는다.
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, dist[i]);
        }

        int count = 0;

        // 가장 먼 거리값을 가진 노드의 개수를 센다.
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }
}

