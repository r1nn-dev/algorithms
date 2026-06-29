// Solution2: BFS + distance 배열 분리 방식

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
		    // 행, 열 크기
        int n = maps.length;
        int m = maps[0].length;

        // 시작점에서 각 칸까지의 최단 거리를 저장하는 배열이다. 
        int[][] distance = new int[n][m];
        
        // 상, 하, 좌, 우 이동을 위한 방향 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // BFS에 사용할 큐 - 각 원소는 {x, y} 형태의 좌표
        Queue<int[]> queue = new ArrayDeque<>();
        
        // 시작점의 거리는 1이다. 
        distance[0][0] = 1; 
        queue.offer(new int[]{0, 0});
        
        // BFS을 수행한다. 
        while (!queue.isEmpty()) {
		        // 현재 좌표 꺼내기
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 도착점에 처음 도달한 순간의 거리가 최단 거리이다. 
            if (x == n - 1 && y == m - 1) { 
                return distance[x][y]; 
            }
            
            // 상하좌우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 1. 범위 체크: 범위를 벗어나면 건너뛴다.
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

				        // 벽이면 이동할 수 없다. 
                if (maps[nx][ny] == 0) { 
                    continue; 
                }
				
                // 3. 이미 방문한 칸이면 다시 방문하지 않는다.
                if (distance[nx][ny] != 0) {
                    continue;
                }
                
                // 4. 거리 갱신
                // 처음 방문하는 칸이면 현재 칸까지의 거리 +1을 저장한다.
                distance[nx][ny] = distance[x][y] + 1;
                
                // 5. 다음 탐색을 위해 큐에 삽입
                queue.offer(new int[]{nx, ny});
            }
        }
        
        // 도착점에 도달할 수 없는 경우이다.
        return -1;
        }
    }
}
