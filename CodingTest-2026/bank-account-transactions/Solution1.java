// Solution1: 고객별 잔액 배열을 이용한 거래 시뮬레이션

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 고객 번호를 인덱스로 바로 사용하기 위해 N + 1 크기로 생성한다.
        // 거래 금액의 누적 결과가 int 범위를 초과할 수 있으므로 long을 사용한다.
        long[] balances = new long[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int customerNumber = Integer.parseInt(st.nextToken());
            int command = Integer.parseInt(st.nextToken());
            long amount = Long.parseLong(st.nextToken());

            if (command == 1) {
                // 입금 거래는 잔액에 거래 금액을 더한다.
                balances[customerNumber] += amount;
            } else if (balances[customerNumber] >= amount) {
                // 출금 거래는 현재 잔액이 충분한 경우에만 처리한다.
                balances[customerNumber] -= amount;
            }
            // 잔액이 부족한 출금 거래는 아무 작업도 하지 않는다.
        }

        StringBuilder result = new StringBuilder();

        // 1번 고객부터 N번 고객까지 최종 잔액을 출력한다.
        for (int customerNumber = 1; customerNumber <= n; customerNumber++) {
            result.append(balances[customerNumber]).append('\n');
        }

        System.out.print(result);
    }
}
