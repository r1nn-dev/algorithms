// Solution2: Floyd-Warshall 기반 승패 관계 갱신 방식

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // win[A][B]는 A 선수가 B 선수를 이길 수 있다는 의미이다.
        boolean[][] win = new boolean[n + 1][n + 1];

        // 직접 경기 결과를 저장한다.
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
      
            win[winner][loser] = true;
        }  

        // 중간 선수 k를 거쳐 알 수 있는 간접 승패 관계를 갱신한다.
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // i가 k를 이기고, k가 j를 이기면 i는 j를 이길 수 있다.
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }

        // 각 선수마다 순위를 정확하게 알 수 있는지 확인한다.
        for (int player = 1; player <= n; player++) {
            int knownCount = 0;
      
            for (int other = 1; other <= n; other++) {
                if (player == other) {
                    continue;
                }
        
                // player가 other를 이기거나, other가 player를 이기면
                // 두 선수의 상대적 순위를 알 수 있다.
                if (win[player][other] || win[other][player]) {
                    knownCount++;
                }
            }
      
            // 다른 모든 선수와의 상대적 관계를 알 수 있으면 순위가 확정된다.
            if (knownCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}

