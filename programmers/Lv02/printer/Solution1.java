// Solution1: Queue에 다 저장하는 방식 (권장)

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 문서의 중요도와 원래 위치를 함께 저장하는 큐이다.
        Queue<int[]> queue = new LinkedList<>();

        // priorities 배열을 순회하면서 [중요도, 원래 위치] 형태로 큐에 넣는다.
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }

        // 현재까지 인쇄된 문서의 개수이다.
        int printOrder = 0;

        // 찾는 문서가 인쇄될 때까지 반복한다.
        while (!queue.isEmpty()) {
            // 큐의 맨 앞 문서를 꺼낸다.
            int[] current = queue.poll();

            // 현재 문서보다 우선순위가 높은 문서가 큐 안에 있는지 확인한다.
            boolean hasHigherPriority = false;

            for (int[] document : queue) {
                if (document[0] > current[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            // 더 높은 우선순위의 문서가 있으면 현재 문서를 큐 뒤에 다시 넣는다.
            if (hasHigherPriority) {
                queue.offer(current);
            } 
            // 더 높은 우선순위의 문서가 없으면 현재 문서를 인쇄한다.
            else {
                printOrder++;

                // 인쇄한 문서의 원래 위치가 location이면 정답을 반환한다.
                if (current[1] == location) {
                    return printOrder;
                }
            }
        }

        return -1;
    }
}
