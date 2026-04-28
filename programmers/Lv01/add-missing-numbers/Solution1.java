// Solution1: 전체 합에서 numbers의 합을 빼는 방식

class Solution {
    public int solution(int[] numbers) {
        // 0부터 9까지의 전체 합 = 45 
        int answer = 45;

        // numbers에 존재하는 숫자는 전체 합에서 제거한다.
        for (int num : numbers) {
            answer -= num;
        }

        // 남은 값은 numbers에 없는 숫자들의 합이다.
        return answer;
    }
}
