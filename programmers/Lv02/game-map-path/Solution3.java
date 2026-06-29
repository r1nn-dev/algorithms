// BFS + visited 배열 + 객체 방식 — BFS 원리 이해용

import java.util.*;

// 현재 좌표를 표현하는 클래스
class Location {
    int x, y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 현재 위치와 다른 위치가 같은지 비교
    public boolean equals(Location other) {
        return this.x == other.x && this.y == other.y;
    }

    // 상하좌우로 이동한 새로운 위치 반환
    Location up() {
        return new Location(x - 1, y);
    }
    Location down() {
        return new Location(x + 1, y);
    }
    Location left() {
        return new Location(x, y - 1);
    }
    Location right() {
        return new Location(x, y + 1);
    }
}

// BFS에서 사용할 상태 정보
// location: 현재 위치
// steps: 시작점부터 현재 위치까지의 이동 거리
class Position {
    int steps;
    Location location;

    Position(Location location, int steps) {
        this.location = location;
        this.steps = steps;
    }
}

class Solution {
    public int solution(int[][] maps) {
        // x = 행(row), y = 열(column)로 사용
        final int mapSizeX = maps.length;
        final int mapSizeY = maps[0].length;

        // 목표 지점: 오른쪽 아래 끝 좌표
        final Location target = new Location(mapSizeX - 1, mapSizeY - 1);

        // 방문 여부 체크 배열
        boolean[][] visited = new boolean[mapSizeX][mapSizeY];

        // BFS를 위한 큐
        Queue<Position> queue = new LinkedList<>();

        // 시작 지점 (0, 0), 시작 거리 1
        queue.offer(new Position(new Location(0, 0), 1));

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            int x = now.location.x;
            int y = now.location.y;

            // 1. 범위를 벗어나면 건너뛴다. 
            if (x < 0 || x >= mapSizeX || y < 0 || y >= mapSizeY) {
                continue;
            }

            // 2. 벽이면 건너뛴다. 
            if (maps[x][y] == 0) {
                continue;
            }

            // 3. 이미 방문한 칸이면 건너뛴다. 
            if (visited[x][y]) {
                continue;
            }

            // 4. 목표 위치에 도착하면 이동 거리 반환
            if (now.location.equals(target)) {
                return now.steps;
            }

            // 5. 현재 위치 방문 처리
            visited[x][y] = true;

            // 6. 다음 위치들을 큐에 삽입
            queue.offer(new Position(now.location.up(), now.steps + 1));
            queue.offer(new Position(now.location.down(), now.steps + 1));
            queue.offer(new Position(now.location.left(), now.steps + 1));
            queue.offer(new Position(now.location.right(), now.steps + 1));
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }
}
