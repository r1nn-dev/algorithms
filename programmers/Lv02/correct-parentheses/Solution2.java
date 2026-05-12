// Solution2: Stack 방식

class Solution {
    boolean solution(String s) {
        // 아직 닫히지 않은 '(' 를 저장할 Stack 역할의 Deque
        Deque<Character> stack = new ArrayDeque<>();

        // 문자열을 왼쪽부터 한 글자씩 확인한다.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // '(' 이면 나중에 닫혀야 하므로 Stack에 저장한다.
            if (ch == '(') {
                stack.push(ch);
            }
            // ')' 이면 이전에 열린 '(' 하나와 짝을 맞춘다.
            else {
                // 닫을 수 있는 '(' 가 없으면 올바르지 않은 괄호이다.
                if (stack.isEmpty()) {
                    return false;
                }

                // 가장 최근에 열린 '(' 하나를 닫는다.
                stack.pop();
            }
        }

        // 모든 괄호를 확인한 뒤 Stack이 비어 있어야 한다.
        return stack.isEmpty();
    }
}
