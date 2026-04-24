class Solution {
    public String solution(String s) {
        // 공백 기준으로 문자열 분리
        String[] arr = s.split(" ");
        
        // 첫 번째 값을 정수로 변환해서 min, max 초기화
        int first = Integer.parseInt(arr[0]);
        int min = first;
        int max = first;
        
        // 두 번째 원소부터 끝까지 순회하면서 최솟값, 최댓값 갱신
        for (int i = 1; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            
            // 현재 숫자가 min보다 작으면 최솟값 갱신
            if (num < min) {
                min = num;
            }
            
            // 현재 숫자가 max보다 크면 최댓값 갱신
            if (num > max) {
                max = num;
            }
        }
        
        // 반환 형식: "최솟값 최댓값"
        return min + " " + max;
    }
}
