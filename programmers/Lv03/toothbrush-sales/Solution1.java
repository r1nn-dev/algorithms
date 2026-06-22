// 부모 포인터 + 반복 전파 방식 (권장)

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> nameIndexMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            nameIndexMap.put(enroll[i], i);
        }
        
        int[] parent = new int[enroll.length];
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = nameIndexMap.get(referral[i]);
            }
        }
        
        for (int i = 0; i < seller.length; i++) {
            int current = nameIndexMap.get(seller[i]);
            int money = amount[i] * 100;

            // 판매자부터 추천인 방향으로 수익을 전파한다.
            while (current != -1 && money > 0) {
                int commission = money / 10;
                int profit = money - commission;
                
                // 현재 판매원은 추천인에게 넘긴 금액을 제외한 나머지를 가진다.
                answer[current] += profit;
                
                // 추천인에게 넘길 금액이 없으면 전파를 종료한다.
                if (commission == 0) {
                    break;
                }
                
                money = commission;
                current = parent[current];
            }
        }
        
        return answer;
    }
}

