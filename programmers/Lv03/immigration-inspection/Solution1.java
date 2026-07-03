// Solution1: 이진탐색 기반 Parametric Search 방식 

class Solution {
    public long solution(int n, int[] times) {
        // 가장 빠른 심사 시간을 저장할 변수
        long minTime = Long.MAX_VALUE;

        // 가장 빠른 심사 시간을 찾는다.
        // 가장 빠른 심사관이 모든 사람을 심사하는 시간이 최대 후보가 된다.
        for (int time : times) {
            minTime = Math.min(minTime, time);
        }

        // 정답이 될 수 있는 최소 시간
        long left = 1;
        // 가장 빠른 심사관이 혼자 n명을 모두 심사하는 시간이 최대 후보가 된다.
        long right = minTime * n;
        // 가능한 시간 중 최솟값을 저장할 변수
        long answer = right;

        // 시간 범위에 대해 이진탐색을 수행한다.
        while (left <= right) {
            long mid = left + (right - left) / 2;

            // mid분 동안 심사할 수 있는 총 인원 수
            long count = 0;

            // 모든 심사관이 mid분 동안 처리할 수 있는 사람 수를 계산한다.
            for (int time : times) {
                count += mid / time;

                // n명 이상 심사 가능하면 더 이상 계산할 필요가 없다.
                // count가 매우 커지는 상황도 막을 수 있다.
                if (count >= n) {
                    break;
                }
            }

            // mid분 안에 모든 사람을 심사할 수 있는 경우
            if (count >= n) {
                // mid분 안에 모든 사람을 심사할 수 있다.
                answer = mid;
                // 더 짧은 시간도 가능한지 확인한다.
                right = mid - 1;
            } 
            // mid분 안에 모든 사람을 심사할 수 없는 경우
            else {
                // mid분으로는 모든 사람을 심사할 수 없다.
                // 더 긴 시간이 필요하다.
                left = mid + 1;
            }
        }

        // 모든 사람을 심사할 수 있는 최소 시간을 반환한다.
        return answer;
    }
}
