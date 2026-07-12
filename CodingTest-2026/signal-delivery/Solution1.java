// Solution1: 방향 상태 기반 다익스트라 
import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static char[][] map;

    static int startR;
    static int startC;
    static int endR;
    static int endC;

    // 위, 아래, 왼쪽, 오른쪽, 왼쪽 위, 왼쪽 아래, 오른쪽 위, 오른쪽 아래
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};

    static class State implements Comparable<State> {
        int r;
        int c;
        int dir;
        long cost;

        State(int r, int c, int dir, long cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c);

                if (map[r][c] == 'S') {
                    startR = r;
                    startC = c;
                }

                if (map[r][c] == 'E') {
                    endR = r;
                    endC = c;
                }
            }
        }

        System.out.println(dijkstra());
    }

    static long dijkstra() {
        long INF = Long.MAX_VALUE / 4;

        long[][][] dist = new long[N][M][8];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                Arrays.fill(dist[r][c], INF);
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>();

        // 본사 S에서는 처음에 여덟 방향 중 하나를 자유롭게 선택할 수 있다.
        for (int dir = 0; dir < 8; dir++) {
            dist[startR][startC][dir] = 0;
            pq.offer(new State(startR, startC, dir, 0));
        }

        while (!pq.isEmpty()) {
            State current = pq.poll();

            if (current.cost != dist[current.r][current.c][current.dir]) {
                continue;
            }

            // 우선순위 큐 특성상 E에 처음 도착한 시간이 최솟값이다.
            if (current.r == endR && current.c == endC) {
                return current.cost;
            }

            char currentCell = map[current.r][current.c];

            // S와 안테나는 신호를 받은 뒤 여덟 방향 중 하나를 선택할 수 있다.
            if (currentCell == 'S' || currentCell == '.') {
                for (int nextDir = 0; nextDir < 8; nextDir++) {
                    move(current, nextDir, dist, pq);
                }
            }
            // 숫자 칸은 현재 진행 방향으로만 신호가 지나갈 수 있다.
            else {
                move(current, current.dir, dist, pq);
            }
        }

        return -1;
    }

    static void move(State current, int nextDir, long[][][] dist, PriorityQueue<State> pq) {
        int nr = current.r + dr[nextDir];
        int nc = current.c + dc[nextDir];

        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
            return;
        }

        // 경쟁사 칸은 지나갈 수 없다.
        if (map[nr][nc] == '#') {
            return;
        }

        // 현재 칸에서 다음 칸으로 이동할 때 현재 칸의 저항력만큼 시간이 든다.
        long nextCost = current.cost + getResistance(map[current.r][current.c]);

        if (nextCost < dist[nr][nc][nextDir]) {
            dist[nr][nc][nextDir] = nextCost;
            pq.offer(new State(nr, nc, nextDir, nextCost));
        }
    }

    static int getResistance(char cell) {
        if ('1' <= cell && cell <= '9') {
            return cell - '0';
        }

        // S, E, . 의 저항력은 모두 1이다.
        return 1;
    }
}

