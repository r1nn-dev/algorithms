// Solution1: 연속 구간 길이 계산

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String teams = br.readLine();

        int redEnergy = 0;
        int blueEnergy = 0;

        // 첫 번째 치어리더를 기준으로 첫 연속 구간을 시작한다.
        char currentTeam = teams.charAt(0);
        int count = 1;

        // 두 번째 치어리더부터 현재 연속 구간과 같은 팀인지 확인한다.
        for (int i = 1; i < n; i++) {
            char team = teams.charAt(i);

            if (team == currentTeam) {
                // 같은 팀이 연속되면 현재 구간의 길이를 증가시킨다.
                count++;
            } else {
                // 팀이 바뀌면 지금까지의 연속 구간 에너지를 계산한다.
                int energy = count * count;

                if (currentTeam == 'R') {
                    redEnergy += energy;
                } else {
                    blueEnergy += energy;
                }

                // 새로운 팀의 연속 구간을 시작한다.
                currentTeam = team;
                count = 1;
            }
        }

        // 반복문 내부에서는 마지막 연속 구간이 처리되지 않으므로 별도로 계산한다.
        int lastEnergy = count * count;

        if (currentTeam == 'R') {
            redEnergy += lastEnergy;
        } else {
            blueEnergy += lastEnergy;
        }

        System.out.println(redEnergy + " " + blueEnergy);
    }
}
