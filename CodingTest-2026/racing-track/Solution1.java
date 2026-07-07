// Solution1: 사이클 경로 직접 추적 + 모듈러 연산

import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static long T;
    static char[][] track;
    
    // 상, 하, 좌, 우
    // static int[] dr = {-1, 1, 0, 0};
    // static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        track = new char[N][M];

        for (int r = 0; r < N; r++) {
        String line = br.readLine();

            for (int c = 0; c < M; c++) {
                track[r][c] = line.charAt(c);
            }
        }

        // 자동차가 지나가는 도로 칸을 순서대로 저장한다.
        ArrayList<int[]> path = new ArrayList<>();

        // 시작 위치는 0초일 때의 위치이다.
        int startR = 0;
        int startC = 0;
        path.add(new int[] {startR, startC});

        // 문제에서 자동차는 처음에 오른쪽으로 이동한다고 했다.
        int prevR = startR;
        int prevC = startC;
        int curR = 0;
        int curC = 1;

        // 다시 시작점으로 돌아오기 전까지 한 바퀴 경로를 추적한다.
        while (!(curR == startR && curC == startC)) {
        path.add(new int[] {curR, curC});

        int nextR = -1;
        int nextC = -1;

        // 현재 칸과 인접한 도로 칸 중에서,
        // 직전에 지나온 칸이 아닌 칸을 다음 위치로 선택한다.
        for (int d = 0; d < 4; d++) {
            int nr = curR + dr[d];
            int nc = curC + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
            continue;
            }

            if (track[nr][nc] != '0') {
            continue;
            }

            // 이전 칸으로 되돌아가는 것은 자동차의 진행 방향이 아니다.
            if (nr == prevR && nc == prevC) {
            continue;
            }

            nextR = nr;
            nextC = nc;
            break;
        }

        // 다음 이동을 위해 이전 위치와 현재 위치를 갱신한다.
        prevR = curR;
        prevC = curC;
        curR = nextR;
        curC = nextC;
        }

        // 트랙은 순환하므로 T초 후 위치는 T % 한 바퀴 길이로 구할 수 있다.
        int index = (int) (T % path.size());
        int[] answer = path.get(index);

        // 문제는 1행 1열 기준으로 출력해야 한다.
        System.out.println((answer[0] + 1) + " " + (answer[1] + 1));
    }
}
