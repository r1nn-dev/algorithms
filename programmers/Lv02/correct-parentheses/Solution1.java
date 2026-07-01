// Solution1: 카운터 방식 (권장)

class Solution {
    boolean solution(String s) {
        if (s.length() % 2 == 1) { 
            return false; 
        }
        
        // 1. 아직 닫히지 않은 '(' 개수를 저장할 변수를 만든다.
        int count = 0;

        // 2. 문자열을 왼쪽부터 오른쪽으로 한 글자씩 확인한다.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 3. 현재 문자가 '(' 이면 닫혀야 할 괄호가 하나 늘어난다.
            if (ch == '(') {
                count++;
            }
            // 4. 현재 문자가 ')' 이면 열린 괄호 하나를 닫는다.
            else {
                count--;

                // 5. count가 음수가 되면 닫을 '(' 없이 ')' 가 나온 것이므로 false를 반환한다.
                if (count < 0) {
                    return false;
                }
            }
        }

        // 6. 모든 문자를 확인한 뒤 열린 괄호가 남아 있지 않으면 true를 반환한다.
        return count == 0;
    }
}
