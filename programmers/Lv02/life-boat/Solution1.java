// Solution1: 정렬 + 투 포인터 방식 (권장)
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 몸무게를 오름차순으로 정렬한다.
        Arrays.sort(people);

        // 가장 가벼운 사람의 위치
        int left = 0;
        // 가장 무거운 사람의 위치
        int right = people.length - 1;
        // 필요한 구명보트 개수
        int boats = 0;

        // 모든 사람을 처리할 때까지 반복한다.
        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람이 함께 탈 수 있는 경우이다.
            if (people[left] + people[right] <= limit) {
                left++;        // 가벼운 사람도 탑승 성공
                right--;
            }
            // 함께 탈 수 없는 경우 가장 무거운 사람만 혼자 태운다. 
            else { 
                right--; 
            }

            // 위 두 경우 모두 보트 하나를 사용한다. 
            answer++;
        }

        return boats;
}
