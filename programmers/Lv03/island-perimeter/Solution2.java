// Solution2: 전체 육지 둘레에서 공유 변 차감 방식

class Solution {
    public int solution(int[][] grid) {
        // 전체 행 개수
        int rows = grid.length;
        // 전체 열 개수
        int cols = grid[0].length;

        // 섬의 둘레 길이를 누적할 변수
        int perimeter = 0;

        // 2차원 배열의 모든 칸을 순회한다.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 현재 칸이 물이면 둘레 계산 대상이 아니므로 건너뛴다.
                if (grid[row][col] == 0) {
                    continue;
                }

                // 육지 칸 하나는 기본적으로 네 변을 가진다.
                perimeter += 4;

                // 위쪽 칸도 육지이면 두 칸이 공유하는 변 2개는 둘레에서 제외한다.
                if (row > 0 && grid[row - 1][col] == 1) {
                    perimeter -= 2;
                }

                // 왼쪽 칸도 육지이면 두 칸이 공유하는 변 2개는 둘레에서 제외한다.
                if (col > 0 && grid[row][col - 1] == 1) {
                    perimeter -= 2;
                }
            }
        }

        // 계산된 섬의 둘레 길이를 반환한다.
        return perimeter;
    }
}
