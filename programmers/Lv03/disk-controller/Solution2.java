// Solution2: 전체 탐색 방식

class Solution {

    public int solution(int[][] jobs) {
        int n = jobs.length;

        // 1. 각 작업의 처리 여부를 저장한다.
        boolean[] visited = new boolean[n];

        // 2. 필요한 변수를 초기화한다.
        int time = 0;       // 현재 시각
        int count = 0;      // 처리 완료한 작업 수
        int totalTime = 0;  // 반환 시간 누적합

        // 3. 모든 작업을 처리할 때까지 반복한다.
        while (count < n) {

            // 현재 시각에 처리할 작업의 인덱스
            int selected = -1;

            // 3-1. 전체 작업을 탐색하면서 현재 처리 가능한 작업을 찾는다.
            for (int i = 0; i < n; i++) {

                // 이미 처리한 작업이면 건너뛴다.
                if (visited[i]) {
                    continue;
                }

                // 아직 요청되지 않은 작업이면 건너뛴다.
                if (jobs[i][0] > time) {
                    continue;
                }

                // 아직 선택된 작업이 없다면 현재 작업을 선택한다.
                if (selected == -1) {
                    selected = i;
                }

                // 소요 시간이 더 짧은 작업을 선택한다.
                else if (jobs[i][1] < jobs[selected][1]) {
                    selected = i;
                }

                // 소요 시간이 같다면 요청 시각이 더 빠른 작업을 선택한다.
                else if (jobs[i][1] == jobs[selected][1]
                        && jobs[i][0] < jobs[selected][0]) {
                    selected = i;
                }

                // 소요 시간과 요청 시각이 같다면 작업 번호가 작은 작업을 선택한다.
                else if (jobs[i][1] == jobs[selected][1]
                        && jobs[i][0] == jobs[selected][0]
                        && i < selected) {
                    selected = i;
                }
            }

            // 3-2. 현재 처리 가능한 작업이 없다면 다음 요청 시각으로 이동한다.
            if (selected == -1) {
                int nextTime = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        nextTime = Math.min(nextTime, jobs[i][0]);
                    }
                }

                time = nextTime;
            }

            // 3-3. 처리할 작업이 있다면 해당 작업을 수행한다.
            else {
                visited[selected] = true;

                // 작업을 처리한 만큼 현재 시각을 증가시킨다.
                time += jobs[selected][1];

                // 반환 시간 = 작업 종료 시각 - 작업 요청 시각
                totalTime += time - jobs[selected][0];

                // 처리 완료한 작업 수를 증가시킨다.
                count++;
            }
        }

        // 4. 평균 반환 시간의 정수 부분을 반환한다.
        return totalTime / n;
    }
}
