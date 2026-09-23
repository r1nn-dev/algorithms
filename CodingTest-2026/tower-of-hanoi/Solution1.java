import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long K = Long.parseLong(br.readLine());

        // rodSum[0] = 첫 번째 막대
        // rodSum[1] = 두 번째 막대
        // rodSum[2] = 세 번째 막대
        int[] rodSum = new int[3];

        // 크기 1부터 20까지 각 원반의 현재 위치를 계산한다.
        for (int disk = 1; disk <= 20; disk++) {

            // 이 원반이 처음 움직이는 시점: 2^(disk - 1)
            long firstMove = 1L << (disk - 1);

            // 같은 원반이 다시 움직이는 주기: 2^disk
            long cycle = 1L << disk;

            // K번째 이동까지 현재 원반이 움직인 횟수
            long moveCount = (K + firstMove) / cycle;

            // 원반이 20개이므로
            // 홀수 원반: 0 -> 1 -> 2 -> 0
            // 짝수 원반: 0 -> 2 -> 1 -> 0
            int direction;

            if (disk % 2 == 1) {
                direction = 1;
            } else {
                direction = -1;
            }

            // Java에서는 음수 % 결과가 음수가 될 수 있으므로 +3 후 다시 % 3 한다.
            int position = (int) ((direction * moveCount % 3 + 3) % 3);

            // 현재 원반의 크기를 해당 막대의 합에 더한다.
            rodSum[position] += disk;
        }

        System.out.println(
            rodSum[0] + " " + rodSum[1] + " " + rodSum[2]
        );
    }
}
