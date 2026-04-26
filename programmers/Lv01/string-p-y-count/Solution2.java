// Solution2: 단일 카운터 방식 

class Solution {
    boolean solution(String s) {
        int count = 0;
        
        // 문자열을 한 글자씩 전체 순회
        // 대소문자 구분 제거
        // toLowerCase(): 문자열을 모두 소문자로 변환
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') count++;   // p 이면 -> count 1 증가
            if (c == 'y') count--;   // y 이면 -> count 1 감소 
        }

        // count가 0이면 p와 y 개수가 같다 => true 반환
        return count == 0;
    }
}
