// Solution1: 차분 배열 + 정렬 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] values = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Long.parseLong(st.nextToken());
        }

        /*
         * count[i]는 차분 배열로 사용한다.
         * 각 위치가 Q개의 구간에 몇 번 포함되는지 계산한다.
         */
        long[] count = new long[n + 1];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            // 입력은 1-based이므로 배열 인덱스에 맞게 변환한다.
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            // [left, right] 구간에 1을 더하는 차분 배열 처리
            count[left]++;
            count[right + 1]--;
        }

        // 누적 합을 통해 각 위치가 구간에 포함된 횟수를 계산한다.
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }

        /*
         * 전체 합을 최대화하려면
         * 큰 배열 값과 큰 등장 횟수를 서로 대응시킨다.
         */
        Arrays.sort(values);
        Arrays.sort(count, 0, n);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer += values[i] * count[i];
        }

        System.out.println(answer);
    }
}
