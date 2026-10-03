// Solution1: 빈 칸 기준 8방향 탐색

import java.io.*;
import java.util.*;

class Main {

    // 현재 칸을 기준으로 확인할 8방향
    // 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
    static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임판의 크기 N과 찾고 싶은 깃발의 값 K를 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 게임판 정보를 저장한다.
        // 0: 빈 칸
        // 1: 구름이 있는 칸
        int[][] board = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 값이 K인 깃발의 개수
        int answer = 0;

        // 게임판의 모든 칸을 순회한다.
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                // 구름이 있는 칸에는 깃발을 설치할 수 없으므로 건너뛴다.
                if (board[r][c] == 1) {
                    continue;
                }

                // 현재 빈 칸 주변에 존재하는 구름의 개수
                int cloudCount = 0;

                // 현재 칸을 기준으로 주변 8방향을 확인한다.
                for (int d = 0; d < 8; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 이동한 위치가 게임판 범위를 벗어나면 확인하지 않는다.
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }

                    // 주변 칸에 구름이 있으면 개수를 증가시킨다.
                    if (board[nr][nc] == 1) {
                        cloudCount++;
                    }
                }

                // 주변 구름의 개수가 K라면
                // 현재 칸에는 값이 K인 깃발이 설치된다.
                if (cloudCount == K) {
                    answer++;
                }
            }
        }

        // 값이 K인 깃발의 총 개수를 출력한다.
        System.out.println(answer);
    }
}
