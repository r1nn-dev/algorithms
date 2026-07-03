// Solution1: 상향식 DP 방식 (권장)

class Solution {
    public int solution(int[][] triangle) {
        // 삼각형의 높이
        int n = triangle.length;

        // 아래에서 두 번째 행부터 꼭대기까지 거꾸로 올라간다.
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < triangle[row].length; col++) {
                // 현재 칸에서 내려갈 수 있는 왼쪽 아래 칸
                int left = triangle[row + 1][col];
                // 현재 칸에서 내려갈 수 있는 오른쪽 아래 칸
                int right = triangle[row + 1][col + 1];

                // 두 경로 중 더 큰 값을 현재 칸에 더한다.
                triangle[row][col] += Math.max(left, right);
            }
        }

        // 꼭대기 칸에는 전체 경로 중 최대 합이 저장된다.
        return triangle[0][0];
    }
}
