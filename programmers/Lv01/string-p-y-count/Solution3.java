class Solution {
	boolean solution(String s) {
		int count = 0;
		
		// 문자열 한 글자씩 순회
        for (char c : s.toCharArray()) {
		    // 대소문자 직접 비교
            if (c == 'p' || c == 'P') count++;        // p나 P 이면 -> count 1 증가
            else if (c == 'y' || c == 'Y') count--;   // y나 Y 이면 -> count 1 감소 
        }

		// count가 0이면 p와 y 개수가 같다 => true 반환
        return count == 0;
    }
}
