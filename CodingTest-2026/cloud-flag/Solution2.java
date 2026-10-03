// Solution2: 구름 기준 주변 카운트 누적

import java.io.*;
import java.util.*;

class Main {

    // 현재 구름을 기준으로 영향을 주는 주변 8방향
    static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임판의 크기 N과 찾고 싶은 깃발의 값 K를 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 원본 게임판
        int[][] board = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // count[r][c]:
        // (r, c) 칸의 주변에 존재하는 구름의 개수를 저장한다.
        int[][] count = new int[N][N];

        // 모든 칸을 순회하면서 구름을 찾는다.
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                // 구름이 없는 칸은 주변에 영향을 줄 필요가 없다.
                if (board[r][c] == 0) {
                    continue;
                }

                // 현재 구름을 기준으로 주변 8칸을 확인한다.
                for (int d = 0; d < 8; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 게임판 범위를 벗어난 위치는 제외한다.
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }

                    // 현재 구름이 주변 칸 하나에 영향을 주므로
                    // 해당 칸의 주변 구름 개수를 1 증가시킨다.
                    count[nr][nc]++;
                }
            }
        }

        // 값이 K인 깃발의 개수
        int answer = 0;

        // 모든 칸의 주변 구름 개수가 계산된 뒤
        // 실제로 깃발을 설치할 수 있는 빈 칸만 확인한다.
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                // 빈 칸이면서 주변 구름의 개수가 K이면
                // 값이 K인 깃발이 설치되는 위치이다.
                if (board[r][c] == 0 && count[r][c] == K) {
                    answer++;
                }
            }
        }

        // 값이 K인 깃발의 총 개수를 출력한다.
        System.out.println(answer);
    }
}
