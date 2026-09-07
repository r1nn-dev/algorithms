import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 나무 수, M: 벌목 기준 높이, x: 시작 위치
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;

        // 각 나무의 높이를 저장한다.
        long[] trees = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        // 벌목 과정 횟수
        int Q = Integer.parseInt(br.readLine());

        // 이동 명령
        st = new StringTokenizer(br.readLine());

        // 모든 나무의 공통 성장량
        long growth = 0;

        // 구름이가 획득한 총 목재량
        long wood = 0;

        for (int i = 0; i < Q; i++) {
            char direction = st.nextToken().charAt(0);

            // 현재 나무의 실제 높이
            long currentHeight = trees[x] + growth;

            // 높이가 M 이상이면 벌목한다.
            if (currentHeight >= M) {
                wood += currentHeight;

                // 실제 높이가 0이 되도록 보정값을 저장한다.
                trees[x] = -growth;
            }

            // 원형으로 이동한다.
            if (direction == 'L') {
                x = (x - 1 + N) % N;
            } else if (direction == 'R') {
                x = (x + 1) % N;
            }
            // S이면 현재 위치를 유지한다.

            // 모든 나무가 1씩 성장한다.
            // 배열 전체를 수정하지 않고 공통 성장량만 증가시킨다.
            growth++;
        }

        // 최종 목재량 출력
        System.out.println(wood);
    }
}
