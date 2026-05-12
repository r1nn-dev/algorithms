// Solution1: 정렬 + PriorityQueue 방식 (권장)

class Solution {

    static class Job {
        int index;        // 작업 번호
        int requestTime;  // 요청 시각
        int duration;     // 소요 시간

        Job(int index, int requestTime, int duration) {
            this.index = index;
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
    
    public int solution(int[][] jobs) {
        int n = jobs.length;

        // 1. jobs 배열을 Job 배열로 변환한다.
        Job[] jobList = new Job[n];

        for (int i = 0; i < n; i++) {
            jobList[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }

        // 2. 작업을 요청 시각 기준으로 정렬한다.
        // 요청 시각이 같으면 작업 번호가 작은 순서로 정렬한다.
        Arrays.sort(jobList, (a, b) -> {
            if (a.requestTime != b.requestTime) {
                return a.requestTime - b.requestTime;
            }
            return a.index - b.index;
        });

        // 3. 현재 처리 가능한 작업을 저장할 PriorityQueue를 만든다.
        // 우선순위:
        // 1) 소요 시간이 짧은 작업
        // 2) 요청 시각이 빠른 작업
        // 3) 작업 번호가 작은 작업
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.duration != b.duration) {
                return a.duration - b.duration;
            }

            if (a.requestTime != b.requestTime) {
                return a.requestTime - b.requestTime;
            }

            return a.index - b.index;
        });

        // 4. 필요한 변수를 초기화한다.
        int time = 0;       // 현재 시각
        int index = 0;      // 아직 PriorityQueue에 넣지 않은 작업의 위치
        int count = 0;      // 처리 완료한 작업 수
        int totalTime = 0;  // 반환 시간 누적합

        // 5. 모든 작업을 처리할 때까지 반복한다.
        while (count < n) {

            // 5-1. 현재 시각까지 요청된 작업을 PriorityQueue에 넣는다.
            while (index < n && jobList[index].requestTime <= time) {
                pq.offer(jobList[index]);
                index++;
            }

            // 5-2. 처리 가능한 작업이 있다면 우선순위가 가장 높은 작업을 꺼낸다.
            if (!pq.isEmpty()) {
                Job current = pq.poll();

                // 작업을 처리한 만큼 현재 시각을 증가시킨다.
                time += current.duration;

                // 반환 시간 = 작업 종료 시각 - 작업 요청 시각
                totalTime += time - current.requestTime;

                // 처리 완료한 작업 수를 증가시킨다.
                count++;
            }

            // 5-3. 처리 가능한 작업이 없다면 다음 작업 요청 시각으로 이동한다.
            else {
                time = jobList[index].requestTime;
            }
        }

        // 6. 평균 반환 시간의 정수 부분을 반환한다.
        return totalTime / n;
    }
}
