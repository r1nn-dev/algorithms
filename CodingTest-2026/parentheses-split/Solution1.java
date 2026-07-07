// Solution1: 괄호 균형값 카운팅

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int balance = 0;
        int answer = 0;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            char ch = S.charAt(i);

            // 여는 괄호는 아직 닫히지 않은 괄호가 하나 늘어난다.
            if (ch == '(') {
                balance++;
            }
            // 닫는 괄호는 이전에 열린 괄호 하나를 닫는다.
            else {
                balance--;
            }

            // 중간에 balance가 음수가 되면 닫는 괄호가 더 많다는 뜻이다.
            // 이 경우 전체 문자열은 올바른 괄호 문자열이 될 수 없다.
            if (balance < 0) {
                isValid = false;
            }

            // 마지막 문자 뒤에서 자르면 한쪽 문자열이 빈 문자열이 된다.
            // 문제는 두 개의 연속한 문자열로 나누는 것이므로, 마지막 위치는 제외한다.
            if (i < N - 1 && balance == 0) {
                answer++;
            }
        }

        // 전체 문자열이 올바른 괄호 문자열이 아니면,
        // 두 개의 올바른 괄호 문자열로 나누는 것도 불가능하다.
        if (!isValid || balance != 0) {
            System.out.println(0);
            return;
        }

        System.out.println(answer);
    }
}
