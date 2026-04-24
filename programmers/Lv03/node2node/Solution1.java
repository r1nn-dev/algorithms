// 방법1: 인접 리스트 + BFS

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
		    // 그래프 -> 인접 리스트: 1번부터 n번까지 사용하므로 n + 1 크기로 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 정보는 양방향이므로 양쪽에 모두 추가
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 각 노드까지의 최단 거리 저장 배열
        // -1: 아직 방문하지 않았다. 
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        
        // 시작 노드는 1번
        queue.offer(1);
        dist[1] = 0;      // 시작점에서 시작점까지의 거리는 0
        
        // BFS 시작
        while (!queue.isEmpty()) {
            int current = queue.poll();
            // 현재 노드와 연결된 모든 다음 노드 확인
            for (int next : graph.get(current)) {
                // 아직 방문하지 않은 노드라면
                if (dist[next] == -1) {
		                // 현재 노드 거리 + 1 이 next 노드까지의 최단 거리
                    dist[next] = dist[current] + 1;
                    // 다음 탐색을 위해 큐에 삽입
                    queue.offer(next);
                }
            }
        }
        
        // 거리 배열에서 최댓값 찾기
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        // 최댓값과 같은 거리를 가진 노드 개수 세기
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                count++;
            }
        }
        
        // 가장 멀리 떨어진 노드의 개수 반환
        return count;
    }
}
