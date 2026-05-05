// Solution2: 반복문 누적 방식

class Solution {
    public long solution(int a, int b) {
        // a와 b 중 작은 값을 반복 시작값으로, 큰 값을 반복 종료값으로 사용한다.
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        // 누적 합은 int 범위를 넘을 수 있으므로 long 타입으로 선언한다.
        long sum = 0;

        // 반복문 - min부터 max까지 양 끝값을 모두 포함해서 순회한다.
        for (int i = min; i <= max; i++) {
            // 현재 정수 i를 sum에 누적한다.
            sum += i;
        }

        // 최종 누적 합 sum을 반환한다.
        return sum;
    }
}
