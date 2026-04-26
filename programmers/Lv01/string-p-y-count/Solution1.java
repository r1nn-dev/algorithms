class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        // 대소문자 구분 제거
        // toLowerCase(): 문자열을 모두 소문자로 변환
        s = s.toLowerCase();

        // 문자열을 한 글자씩 전체 순회하며 p, y 개수 카운팅
        for (char c : s.toCharArray()) {
            if (c == 'p') pCount++;        // p 개수 증가
            else if (c == 'y') yCount++;   // y 개수 증가
        }

        // p 개수와 y 개수가 같으면 true, 다르면 false 반환 
        return pCount == yCount;
    }
}
