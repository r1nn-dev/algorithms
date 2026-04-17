import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N = 1이면 a+b=1을 만족하는 양의 정수 쌍이 없음
        if (N == 1) {
            System.out.println(0);
            return;
        }

        // N = 2이면 (1,1) 한 가지 가능
        if (N == 2) {
            System.out.println(1);
            return;
        }

        // 오일러 피 함수 phi(N) 계산
        // phi(N) = 1 이상 N 이하의 수 중에서 N과 서로소인 수의 개수
        int phi = N;
        int x = N;

        // 소인수분해를 이용해 phi(N) 계산
        for (int i = 2; (long) i * i <= x; i++) {
            if (x % i == 0) {
                // i가 소인수라면 x에서 i를 모두 제거
                while (x % i == 0) {
                    x /= i;
                }
                // phi 공식 적용: phi = phi * (1 - 1/p)
                phi -= phi / i;
            }
        }

        // 마지막에 소인수가 하나 더 남아 있는 경우 처리
        if (x > 1) {
            phi -= phi / x;
        }

        // N > 2에서는 서로소인 a들이 (a, N-a) 쌍으로 대칭이므로 절반만 세면 됨
        System.out.println(phi / 2);
    }
}
