// Solution1: 육지 칸 기준 4방향 확인 방식 (권장)

class Solution {
    public int solution(int[][] grid) {
        // 전체 행 개수
        int rows = grid.length;
        // 전체 열 개수
        int cols = grid[0].length;
        // 섬의 둘레 길이를 누적할 변수
        int perimeter = 0;

        // 행 변화량 - 상, 하, 좌, 우 방향으로 이동
        int[] dr = {-1, 1, 0, 0};
        // 열 변화량 - 상, 하, 좌, 우 방향으로 이동
        int[] dc = {0, 0, -1, 1};

        // 2차원 배열의 모든 칸을 순회한다.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 현재 칸이 물이면 둘레 계산 대상이 아니므로 건너뛴다.
                if (grid[row][col] == 0) {
                    continue;
                }

                // 현재 칸이 육지이면 상하좌우 4방향을 확인한다.
                for (int dir = 0; dir < 4; dir++) {
                    int nextRow = row + dr[dir];
                    int nextCol = col + dc[dir];

                    // 다음 위치가 격자 바깥이면 해당 변은 둘레에 포함된다.
                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                        perimeter++;
                    }
                    // 다음 위치가 물이면 해당 변은 둘레에 포함된다.
                    else if (grid[nextRow][nextCol] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        // 계산된 섬의 둘레 길이를 반환한다.
        return perimeter;
    }
}
