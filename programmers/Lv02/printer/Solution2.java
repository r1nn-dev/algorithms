// Solution2: Queue + 우선순위 개수 배열 사용하는 방식

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 문서의 중요도와 원래 위치를 함께 저장하는 큐이다.
        Queue<int[]> queue = new LinkedList<>();

        // 우선순위는 1부터 9까지이므로 크기 10의 배열을 사용한다.
        int[] count = new int[10];

        // 큐에는 [중요도, 원래 위치]를 저장하고, 우선순위 개수도 함께 센다.
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
            count[priorities[i]]++;
        }

        // 현재까지 인쇄된 문서의 개수이다.
        int printOrder = 0;

        // 찾는 문서가 인쇄될 때까지 반복한다.
        while (!queue.isEmpty()) {
            // 큐의 맨 앞 문서를 꺼낸다.
            int[] current = queue.poll();

            // 현재 큐에 남아 있는 문서 중 가장 높은 우선순위를 찾는다.
            int maxPriority = getMaxPriority(count);

            // 현재 문서보다 우선순위가 높은 문서가 남아 있으면 다시 큐 뒤에 넣는다.
            if (current[0] < maxPriority) {
                queue.offer(current);
            } 
            // 현재 문서가 가장 높은 우선순위라면 인쇄한다.
            else {
                printOrder++;

                // 인쇄했으므로 해당 우선순위의 남은 개수를 1 감소시킨다.
                count[current[0]]--;

                // 인쇄한 문서의 원래 위치가 location이면 정답을 반환한다.
                if (current[1] == location) {
                    return printOrder;
                }
            }
        }

        return -1;
    }

    private int getMaxPriority(int[] count) {
        // 우선순위는 숫자가 클수록 높으므로 9부터 1까지 확인한다.
        for (int priority = 9; priority >= 1; priority--) {
            if (count[priority] > 0) {
                return priority;
            }
        }

        return 0;
    }
}
