class Solution {
    public int solution(int n) {
        int sum = 0;

        // 정수를 문자열로 변환한 뒤, 각 문자를 하나씩 순회
        for (char ch : String.valueOf(n).toCharArray()) {
            sum += ch - '0'; // 문자 숫자를 실제 정수 값으로 변환
        }

        return sum;
    }
}
