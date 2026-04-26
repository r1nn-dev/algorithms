// Solution2: 나머지 연산 방식 

class Solution {
    public int solution(int n) {
        int sum = 0;

        // 일의 자리 숫자를 하나씩 추출하면서 합산
        while (n > 0) {
            sum += n % 10; // 현재 일의 자리 숫자 추출
            n /= 10;       // 일의 자리 제거
        }

        return sum;
    }
}
