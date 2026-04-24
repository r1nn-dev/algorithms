// BFS + maps 배열 재사용 (권장)

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
		    // 행, 열 크기
        int n = maps.length;
        int m = maps[0].length;
        
        // 상, 하, 좌, 우 이동을 위한 방향 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // BFS에 사용할 큐 - 각 원소는 {x, y} 형태의 좌표
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 (0, 0) 삽입
        queue.offer(new int[]{0, 0});
        
        // BFS 시작
        while (!queue.isEmpty()) {
		        // 현재 좌표 꺼내기
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 1. 범위 체크: 범위를 벗어나면 건너뛴다.
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                // 2. 벽(0)이거나 이미 방문한 칸(1이 아닌 값)이면 건너뛴다.
                if (maps[nx][ny] != 1) {
                    continue;
                }
                
                // 3. 거리 갱신
                // 처음 방문하는 칸이면 현재 칸까지의 거리 +1을 저장한다.
                maps[nx][ny] = maps[x][y] + 1;
                
                // 4. 다음 탐색을 위해 큐에 삽입
                queue.offer(new int[]{nx, ny});
            }
        }
        
        // 도착점이 끝까지 1이면 도달하지 못한 것이므로 -1 반환
        if (maps[n - 1][m - 1] == 1) {
            return -1;
        }
        
        // 도착점에 저장된 값이 곧 최단거리
        return maps[n - 1][m - 1];
    }
}
