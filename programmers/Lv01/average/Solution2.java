// Solution2: Stream 방식

import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        // 1. 배열을 스트림으로 변환한다.
        // 2. 평균값을 계산한다.
        // 3. arr의 길이는 1 이상이므로 평균값이 항상 존재한다.
        return Arrays.stream(arr).average().getAsDouble();
    }
}
