// Solution2: 정렬 반복 방식

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] scoville, int K) {
        List<Integer> foods = new ArrayList<>();
        
        for (int value : scoville) {
            foods.add(value);
        }
        
        int count = 0;
        
        while (true) {
            Collections.sort(foods);
            
            if (foods.get(0) >= K) {
                return count;
            }
            
            if (foods.size() < 2) {
                return -1;
            }
            
            int first = foods.remove(0);
            int second = foods.remove(0);
            int mixed = first + second * 2;
            
            foods.add(mixed);
            count++;
        }
    }
}
