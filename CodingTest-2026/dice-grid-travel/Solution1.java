// Solution1: DP 격자 이동 

import java.io.*;

class Main {

  static final long MOD = 1_000_000_007L;

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner(System.in);

    int N = fs.nextInt();
    int M = fs.nextInt();
    int K = fs.nextInt();

    // rest[r][c]가 true이면 해당 칸은 휴식 칸이다.
    boolean[][] rest = new boolean[N + 1][M + 1];

    for (int i = 0; i < K; i++) {
      int r = fs.nextInt();
      int c = fs.nextInt();

      rest[r][c] = true;
    }

    // dp[r][c]: 출발지에서 (r, c)까지 도착하는 경우의 수
    long[][] dp = new long[N + 1][M + 1];

    // 출발지는 항상 휴식 칸이 아니므로 경우의 수 1로 시작한다.
    dp[1][1] = 1;

    for (int r = 1; r <= N; r++) {
      for (int c = 1; c <= M; c++) {

        // 출발지는 이미 초기화했으므로 다시 계산하지 않는다.
        if (r == 1 && c == 1) {
          continue;
        }

        // 휴식 칸에는 이동하면 안 되므로 경우의 수를 0으로 둔다.
        if (rest[r][c]) {
          dp[r][c] = 0;
          continue;
        }

        long count = 0;

        // 주사위 눈이 1~6이므로 위쪽 1~6칸에서 올 수 있다.
        for (int dice = 1; dice <= 6; dice++) {
          int prevR = r - dice;

          if (prevR >= 1) {
            count += dp[prevR][c];
            count %= MOD;
          }
        }

        // 주사위 눈이 1~6이므로 왼쪽 1~6칸에서 올 수 있다.
        for (int dice = 1; dice <= 6; dice++) {
          int prevC = c - dice;

          if (prevC >= 1) {
            count += dp[r][prevC];
            count %= MOD;
          }
        }

        dp[r][c] = count;
      }
    }

    System.out.println(dp[N][M]);
  }

  // 빠른 입력 처리를 위한 클래스
  static class FastScanner {
    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0;
    private int len = 0;

    FastScanner(InputStream in) {
      this.in = in;
    }

    private int read() throws IOException {
      if (ptr >= len) {
        len = in.read(buffer);
        ptr = 0;

        if (len <= 0) {
          return -1;
        }
      }

      return buffer[ptr++];
    }

    int nextInt() throws IOException {
      int c;

      // 공백, 줄바꿈, 탭을 건너뛴다.
      do {
        c = read();
      } while (c <= ' ');

      int value = 0;

      // 숫자 문자를 정수로 변환한다.
      while (c > ' ') {
        value = value * 10 + (c - '0');
        c = read();
      }

      return value;
    }
  }
}
