import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);   // 오름차순 정렬

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;        // 가벼운 사람도 탑승 성공
            }
            right--;           // 무거운 사람은 항상 탑승
            boats++;
        }

        return boats;
}
