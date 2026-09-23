// Solution2: 이동 번호 기반 시뮬레이션 방식

import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long K = Long.parseLong(br.readLine());

        // 처음에는 모든 원반이 첫 번째 막대에 있다.
        // 1 + 2 + ... + 20 = 210
        int[] rodSum = {210, 0, 0};

        // position[disk] = 현재 원반이 위치한 막대 번호
        // 초기값 0이므로 모든 원반은 첫 번째 막대에서 시작한다.
        int[] position = new int[21];

        for (long move = 1; move <= K; move++) {

            // 이동 번호의 trailing zero 개수 + 1이
            // 현재 움직이는 원반의 크기이다.
            int disk = Long.numberOfTrailingZeros(move) + 1;

            // 20개의 원반에서는
            // 홀수 원반은 +1 방향,
            // 짝수 원반은 -1 방향으로 순환한다.
            int direction;

            if (disk % 2 == 1) {
                direction = 1;
            } else {
                direction = -1;
            }

            int current = position[disk];
            int next = (current + direction + 3) % 3;

            // 기존 막대에서 원반을 제거한다.
            rodSum[current] -= disk;

            // 새로운 막대에 원반을 추가한다.
            rodSum[next] += disk;

            // 원반의 현재 위치를 갱신한다.
            position[disk] = next;
        }

        System.out.println(
            rodSum[0] + " " + rodSum[1] + " " + rodSum[2]
        );
    }
}
