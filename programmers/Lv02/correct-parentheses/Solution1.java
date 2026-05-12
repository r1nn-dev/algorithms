// Solution1: 카운터 방식 (권장)

class Solution {
    boolean solution(String s) {
        // 아직 닫히지 않은 '(' 개수를 저장한다.
        int count = 0;

        // 문자열을 왼쪽부터 한 글자씩 확인한다.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // '(' 이면 나중에 닫혀야 할 괄호가 하나 늘어난다.
            if (ch == '(') {
                count++;
            }
            // ')' 이면 이전에 열린 괄호 하나를 닫는다.
            else {
                count--;

                // 닫을 수 있는 '(' 가 없는데 ')' 가 나온 경우이다.
                if (count < 0) {
                    return false;
                }
            }
        }

        // 모든 괄호를 확인한 뒤 열린 괄호가 남아 있지 않아야 한다.
        return count == 0;
    }
}
