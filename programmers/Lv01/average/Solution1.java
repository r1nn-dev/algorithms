// Solution1: 반복문 방식 (권장) 

class Solution {
    public double solution(int[] arr) {
        // 1. 배열 원소의 합계를 저장할 변수를 만든다.
        int sum = 0;

        // 2. 배열의 모든 원소를 하나씩 확인한다.
        for (int num : arr) {
            // 3. 현재 원소를 합계에 누적한다.
            sum += num;
        }

        // 4. 합계를 배열의 길이로 나누어 평균을 반환한다.
        return (double) sum / arr.length;
    }
}
