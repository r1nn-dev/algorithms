// Solution1: Solution1: 정렬 + 이분 탐색 lower bound 방식 

import java.io.*;
import java.util.*;

class Main {

  static int N, Q;
  static long[] points;

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner(System.in);
    StringBuilder sb = new StringBuilder();

    // N: 점의 개수
    // Q: 질의의 개수
    N = fs.nextInt();
    Q = fs.nextInt();

    points = new long[N];

    // 점의 좌표 입력
    // 좌표 범위가 -10^18 ~ 10^18이므로 int가 아니라 long을 사용한다.
    for (int i = 0; i < N; i++) {
      points[i] = fs.nextLong();
    }

    // 이분 탐색을 사용하기 위해 점의 좌표를 오름차순 정렬한다.
    Arrays.sort(points);

    // Q개의 질의를 하나씩 처리한다.
    for (int i = 0; i < Q; i++) {
      long p = fs.nextLong();

      // p 이상인 첫 번째 점의 위치를 찾는다.
      int idx = lowerBound(points, p);

      long answer;

      // p보다 크거나 같은 점이 가장 왼쪽 점이라면 왼쪽 후보만 존재한다.
      if (idx == 0) {
        answer = points[0];
      }

      // p보다 크거나 같은 점이 없다면 가장 오른쪽 점이 정답이다.
      else if (idx == N) {
        answer = points[N - 1];
      }

      // p의 왼쪽 점과 오른쪽 점을 비교한다.
      else {
        long left = points[idx - 1];
        long right = points[idx];

        // p와 왼쪽 점 사이의 거리
        long leftDist = Math.abs(p - left);

        // p와 오른쪽 점 사이의 거리
        long rightDist = Math.abs(right - p);

        // 거리가 같으면 좌표가 더 작은 점을 출력해야 하므로 왼쪽 점을 선택한다.
        if (leftDist <= rightDist) {
          answer = left;
        } else {
          answer = right;
        }
      }

      sb.append(answer).append('\n');
    }

    System.out.print(sb);
  }

  // target 이상인 값이 처음 등장하는 인덱스를 반환한다.
  static int lowerBound(long[] arr, long target) {
    int left = 0;
    int right = arr.length;

    while (left < right) {
      int mid = left + (right - left) / 2;

      // arr[mid]가 target 이상이면 mid도 정답 후보가 될 수 있다.
      if (arr[mid] >= target) {
        right = mid;
      }

      // arr[mid]가 target보다 작으면 오른쪽 구간에서 찾아야 한다.
      else {
        left = mid + 1;
      }
    }

    return left;
  }

  // 빠른 입력 처리를 위한 클래스
  // N, Q가 최대 100,000이므로 Scanner보다 빠른 입력 방식을 사용한다.
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

      // 숫자 문자를 실제 정수 값으로 변환한다.
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
