// Solution2: boolean[] 플래그 배열로 존재 여부를 확인하는 방식

class Solution {
    public int solution(int[] numbers) {
        // 숫자 0부터 9까지의 존재 여부를 저장하는 배열 
        boolean[] exists = new boolean[10];

        // numbers에 들어 있는 숫자를 true로 표시한다.
        for (int num : numbers) {
            exists[num] = true;
        }

        int answer = 0;

        // 0부터 9까지 확인하면서 존재하지 않는 숫자만 더한다.
        for (int i = 0; i <= 9; i++) {
            if (!exists[i]) {
                answer += i;
            }
        }

        // numbers에 없는 숫자들의 합을 반환한다.
        return answer;
    }
}
