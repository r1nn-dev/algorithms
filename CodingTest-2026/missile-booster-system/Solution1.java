// Solution1: 스위핑 + 구간 겹침 계산 

import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner(System.in);

    int N = fs.nextInt();

    // 각 미사일마다 시작 이벤트와 종료 이벤트가 1개씩 필요하다.
    long[] events = new long[2 * N];

    long totalTime = 0;
    int idx = 0;

    for (int i = 0; i < N; i++) {
      long x = fs.nextLong();
      long y = fs.nextLong();
      long start = fs.nextLong();

      // 유클리드 거리의 제곱이다.
      // 실제 거리의 제곱만 필요하므로 sqrt를 사용할 필요가 없다.
      long distSquared = x * x + y * y;

      // 기본 비행 시간은 2 * 거리의 제곱이다.
      long flightTime = 2 * distSquared;

      // 전체 기본 비행 시간 합을 누적한다.
      totalTime += flightTime;

      long end = start + flightTime;

      // events에는 시간을 기준으로 정렬할 수 있도록 인코딩해서 저장한다.
      // time * 2 + 1: 시작 이벤트(+1)
      // time * 2    : 종료 이벤트(-1)
      events[idx++] = start * 2 + 1;
      events[idx++] = end * 2;
    }

    Arrays.sort(events);

    long currentFlying = 0;
    long maxFlying = 0;

    int i = 0;

    while (i < events.length) {
      long time = events[i] / 2;
      long delta = 0;

      // 같은 시각에 발생한 이벤트를 한 번에 처리한다.
      while (i < events.length && events[i] / 2 == time) {
        // 홀수로 인코딩된 값은 시작 이벤트이다.
        if (events[i] % 2 == 1) {
          delta++;
        }

        // 짝수로 인코딩된 값은 종료 이벤트이다.
        else {
          delta--;
        }

        i++;
      }

      // 해당 시각 이후 현재 날아가는 미사일 수를 갱신한다.
      currentFlying += delta;

      // 부스터 효과가 가장 큰 시각을 찾는다.
      maxFlying = Math.max(maxFlying, currentFlying);
    }

    // 부스터는 현재 날아가는 미사일마다 비행 시간을 1씩 줄인다.
    long answer = totalTime - maxFlying;

    System.out.println(answer);
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

    long nextLong() throws IOException {
      int c;

      // 공백, 줄바꿈, 탭을 건너뛴다.
      do {
        c = read();
      } while (c <= ' ');

      int sign = 1;

      // 음수 좌표를 처리한다.
      if (c == '-') {
        sign = -1;
        c = read();
      }

      long value = 0;

      // 숫자 문자를 정수로 변환한다.
      while (c > ' ') {
        value = value * 10 + (c - '0');
        c = read();
      }

      return value * sign;
    }

    int nextInt() throws IOException {
      return (int) nextLong();
    }
  }
}
