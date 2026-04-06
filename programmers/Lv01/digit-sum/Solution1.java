class Solution {
    public int solution(int n) {
        int sum = 0;
        for (char ch : String.valueOf(n).toCharArray()) {
            sum += ch - '0';  // 문자 → 정수 변환
        }
        return sum;
    }
}
