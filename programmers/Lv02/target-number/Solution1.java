class Solution {
    // count: target을 만드는 경우의 수를 저장하는 변수
    int count = 0;

    public int solution(int[] numbers, int target) {
        // DFS 탐색 시작
        // depth = 0 : 첫 번째 숫자부터 시작
        // sum = 0   : 초기 누적합
        dfs(numbers, target, 0, 0);
        return count;
    }

    // DFS 탐색 함수
    // depth: 현재 처리 중인 숫자의 위치(인덱스)
    // sum: 현재까지의 누적합
    void dfs(int[] numbers, int target, int depth, int sum) {
        // 모든 숫자를 다 처리한 경우(리프 노드)
        if (depth == numbers.length) {
            if (sum == target) count++;   // target을 만들면 경우의 수 1 증가
            return;
        }

        // 현재 숫자를 더하는 경우
        dfs(numbers, target, depth + 1, sum + numbers[depth]);

        // 현재 숫자를 빼는 경우
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}
