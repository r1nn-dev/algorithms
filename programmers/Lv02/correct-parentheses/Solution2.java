// Solution2: Stack 방식

class Solution {
    boolean solution(String s) {
        // 1. 아직 닫히지 않은 '(' 를 저장할 Stack을 만든다.
        Deque<Character> stack = new ArrayDeque<>();

        // 2. 문자열을 왼쪽부터 오른쪽으로 한 글자씩 확인한다.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 3. 현재 문자가 '(' 이면 나중에 닫아야 하므로 Stack에 넣는다.
            if (ch == '(') {
                stack.push(ch);
            }

            // 4. 현재 문자가 ')' 이면 이전에 열린 '(' 하나와 짝을 맞춘다.
            else {
                // 5. Stack이 비어 있으면 닫을 '(' 가 없다는 뜻이므로 false를 반환한다.
                if (stack.isEmpty()) {
                    return false;
                }

                // 6. 가장 최근에 열린 '(' 하나를 Stack에서 꺼낸다.
                stack.pop();
            }
        }

        // 7. 모든 문자를 확인한 뒤 Stack이 비어 있으면 모든 괄호가 닫힌 것이다.
        return stack.isEmpty();
    }
}
