// 방법2: 정렬

import java.util.Arrays;

class Solution {
    public String solution(String s) {
		    // 공백 기준으로 문자열 분리
        String[] arr = s.split(" ");
        
        // 문자열 숫자들을 정수 배열로 변환
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        
        // 오름차순 정렬
        Arrays.sort(nums);
        
        // 정렬 후 맨 앞이 최솟값, 맨 뒤가 최댓값
        return nums[0] + " " + nums[nums.length - 1];
    }
}
