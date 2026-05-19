// Solution1: PriorityQueue 방식 (권장) 

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int value : scoville) {
            pq.offer(value);
        }
        
        int count = 0;
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            int mixed = first + second * 2;
            
            pq.offer(mixed);
            count++;
        }
        
        return count;
    }
}
