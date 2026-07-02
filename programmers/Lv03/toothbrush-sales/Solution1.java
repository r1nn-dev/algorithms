// Solution1: 부모 포인터 + 반복 전파 방식 

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> nameIndexMap = new HashMap<>();

        // 판매원 이름을 인덱스로 변환하기 위해 HashMap에 저장한다.
        for (int i = 0; i < enroll.length; i++) {
            nameIndexMap.put(enroll[i], i);
        }

        int[] parent = new int[enroll.length];
        int[] answer = new int[enroll.length];

        // 각 판매원의 추천인을 부모 인덱스로 저장한다.
        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = nameIndexMap.get(referral[i]);
            }
        }

        // 각 판매 기록마다 수익 분배를 수행한다.
        for (int i = 0; i < seller.length; i++) {
            int current = nameIndexMap.get(seller[i]);
            int money = amount[i] * 100;

            // 판매자부터 추천인 방향으로 수익을 전파한다.
            while (current != -1 && money > 0) {
                // 추천인에게 넘길 금액이다.
                int commission = money / 10;

                // 현재 판매원이 실제로 가져갈 금액이다.
                int profit = money - commission;

                answer[current] += profit;

                // 넘길 금액이 0원이면 더 이상 상위로 전파하지 않는다.
                if (commission == 0) {
                    break;
                }

                // 추천인에게 넘긴 금액이 다음 단계의 분배 대상 금액이 된다.
                money = commission;
                current = parent[current];
            }
        }

        return answer;
    }
}
