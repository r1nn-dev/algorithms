// Solution1: 이진탐색 기반 Parametric Search

class Solution {
    public long solution(int n, int[] times) {
        long minTime = Long.MAX_VALUE;

        // 가장 빠른 심사 시간을 찾는다.
        // 가장 빠른 심사관이 모든 사람을 심사하는 시간이 최대 후보가 된다.
        for (int time : times) {
            minTime = Math.min(minTime, time);
        }

        long left = 1;
        long right = minTime * n;
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;

            // mid분 동안 모든 심사관이 처리할 수 있는 사람 수를 계산한다.
            for (int time : times) {
                count += mid / time;

                // n명 이상 심사 가능하면 더 이상 계산할 필요가 없다.
                // count가 매우 커지는 상황도 막을 수 있다.
                if (count >= n) {
                    break;
                }
            }

            if (count >= n) {
                // mid분 안에 모든 사람을 심사할 수 있다.
                // 더 짧은 시간도 가능한지 확인한다.
                answer = mid;
                right = mid - 1;
            } else {
                // mid분으로는 모든 사람을 심사할 수 없다.
                // 더 긴 시간이 필요하다.
                left = mid + 1;
            }
        }

        return answer;
    }
}
