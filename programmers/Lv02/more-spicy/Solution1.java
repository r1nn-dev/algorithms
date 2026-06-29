// Solution1: PriorityQueue 방식 (권장) 

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 가장 작은 스코빌 지수를 빠르게 꺼내기 위한 Min Heap이다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 모든 음식의 스코빌 지수를 우선순위 큐에 넣는다.
        for (int value : scoville) {
            pq.offer(value);
        }

        // 현재까지 음식을 섞은 횟수이다.
        int count = 0;

        // 가장 작은 스코빌 지수가 K보다 작으면 아직 조건을 만족하지 못한 상태이다.
        while (pq.peek() < K) {
            // 음식이 1개만 남았다면 더 이상 두 음식을 섞을 수 없다.
            if (pq.size() < 2) {
                return -1;
            }
            
            // 가장 맵지 않은 음식과 두 번째로 맵지 않은 음식을 꺼낸다. 
            long first = pq.poll(); 
            long second = pq.poll(); 
            
            // 문제에서 주어진 공식에 따라 새 스코빌 지수를 계산한다. 
            long mixed = first + (second * 2);

            // 새로 만든 음식을 다시 우선순위 큐에 넣는다.
            pq.offer(mixed);
            
            // 섞기 횟수를 1 증가시킨다.
            count++;
        }
        
        // 모든 음식의 스코빌 지수가 K 이상이 되었으므로 섞은 횟수를 반환한다.
        return count;
    }
}
