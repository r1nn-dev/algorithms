// Solution1: 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 발사 횟수는 int 범위를 초과할 수 있으므로 long을 사용한다.
        long shots = 0;

        for (int i = 0; i < n; i++) {
            long health = Long.parseLong(st.nextToken());

            /*
             * 공격력은 1, 2, 3, 4 반복, 연속된 4발의 총 데미지는 시작 위치와 관계없이 항상 10이다.
             *
             * 적을 4발 묶음만으로 먼저 쓰러뜨리면 실제로 몇 번째 총알에서 죽었는지 알 수 없으므로,
             * 최소 체력 1은 남도록 묶음을 처리한다.
             */
            long cycles = (health - 1) / 10;

            health -= cycles * 10;
            shots += cycles * 4;

            // 남은 체력은 실제 공격 순서대로 처리한다.
            while (health > 0) {
                // shots가 지금까지 발사한 횟수이므로 다음 공격력은 (shots % 4) + 1이다.
                long damage = (shots % 4) + 1;

                health -= damage;
                shots++;
            }
        }

        System.out.println(shots);
    }
}
