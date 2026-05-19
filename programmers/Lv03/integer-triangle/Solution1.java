// Solution1: 상향식 DP 방식 (권장)

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = triangle[i + 1][j];
                int right = triangle[i + 1][j + 1];
                
                triangle[i][j] += Math.max(left, right);
            }
        }
        
        return triangle[0][0];
    }
}
