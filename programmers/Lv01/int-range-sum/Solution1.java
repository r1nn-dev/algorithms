// Solution1: 등차수열 합 공식 (권장)

class Solution {
    public long solution(int a, int b) {
        // a와 b 중 작은 값을 시작값으로, 큰 값을 끝값으로 사용한다.
        // Math.min()의 반환값은 int이므로 long으로 변환.
        long min = Math.min(a, b);
        long max = Math.max(a, b);

        // min부터 max 사이에 포함되는 정수의 개수를 구한다.
        long count = max - min + 1;

        // 등차수열 합 공식: (첫 항 + 마지막 항) * 항의 개수 / 2
        return (min + max) * count / 2;
    }
}
