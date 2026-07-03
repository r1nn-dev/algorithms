// Solution2: 하향식 1차원 DP 방식 

class Solution {
    public int solution(int[][] triangle) {
        // 삼각형의 높이
        int n = triangle.length;

        // dp[col]은 현재 행의 col 위치까지 도달할 수 있는 최대 합을 의미한다.
        int[][] dp = new int[n][n];

        // 시작점은 삼각형의 꼭대기이다.
        dp[0][0] = triangle[0][0];

        // 두 번째 행부터 마지막 행까지 내려간다.
        for (int row = 1; row < n; row++) {
            // 이전 행의 값이 덮어씌워지지 않도록 오른쪽에서 왼쪽으로 갱신한다.
            for (int col = triangle[row].length - 1; col >= 0; col--) {
                // 오른쪽 끝 칸은 바로 위의 왼쪽 부모에서만 올 수 있다.
                if (col == triangle[row].length - 1) {
                    dp[col] = dp[col - 1] + triangle[row][col];
                } 
                // 왼쪽 끝 칸은 바로 위의 같은 위치에서만 올 수 있다.
                else if (col == 0) {
                    dp[col] = dp[col] + triangle[row][col];
                } 
                // 가운데 칸은 두 부모 중 더 큰 경로에서 올 수 있다.
                else {
                    dp[col] = Math.max(dp[col - 1], dp[col]) + triangle[row][col];
                }
            }
        }

        // 마지막 행에 도달한 경로 합 중 최댓값을 찾는다.
        int answer = dp[0];
        
        for (int value : dp) {
            answer = Math.max(answer, value);
        }
        
        return answer;
    }
}
