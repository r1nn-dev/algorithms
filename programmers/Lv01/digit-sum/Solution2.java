class Solution {
    public int solution(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;  // 일의 자리 추출
            n /= 10;        // 일의 자리 제거
        }
        return sum;
    }
}
