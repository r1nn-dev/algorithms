// Solution1: 정렬 + DFS + 백트래킹 방식

import java.util.*;

class Solution {
    // 항공권 사용 여부를 저장하는 배열 visited 
    private boolean[] visited;
    // 현재까지 만든 여행 경로를 저장하는 리스트 route
    private List<String> route;
    // 전체 항공권 정보 tickets 배열 
    private String[][] tickets;

    public String[] solution(String[][] tickets) {
        // 전달받은 항공권 배열을 전역 변수에 저장한다.
        this.tickets = tickets;

        // 정렬 - 항공권을 알파벳 순서로 정렬한다.
        // 출발 공항이 다르면 출발 공항 기준으로, 출발 공항이 같으면 도착 공항 기준으로 정렬한다.
        Arrays.sort(this.tickets, (t1, t2) -> {
            if (t1[0].equals(t2[0])) {
                return t1[1].compareTo(t2[1]);
            }
            return t1[0].compareTo(t2[0]);
        });

        // 각 항공권을 사용했는지 체크하기 위한 배열이다.
        visited = new boolean[tickets.length];

        // 경로를 저장할 리스트를 생성한다.
        route = new ArrayList<>();

        // 여행은 항상 ICN에서 시작하므로 경로에 먼저 추가한다.
        route.add("ICN");

        // ICN에서 출발하여 사용한 항공권 개수 0개부터 DFS를 시작한다.
        dfs("ICN", 0);

        // List<String>을 String[]로 변환하여 반환한다.
        return route.toArray(new String[0]);
    }

    // DFS 
    private boolean dfs(String currentAirport, int usedCount) {
        // 사용한 항공권 수가 전체 항공권 수와 같다면 모든 항공권을 사용한 것이다.
        if (usedCount == tickets.length) {
            return true;
        }

        // 모든 항공권을 순회하면서 현재 공항에서 출발할 수 있는 항공권을 찾는다.
        for (int i = 0; i < tickets.length; i++) {
            // 이미 사용한 항공권이면 다시 사용할 수 없으므로 건너뛴다.
            if (visited[i]) {
                continue;
            }

            // 현재 공항에서 출발하는 항공권이 아니라면 사용할 수 없으므로 건너뛴다.
            if (!tickets[i][0].equals(currentAirport)) {
                continue;
            }

            // i번째 항공권을 사용 처리한다.
            visited[i] = true;

            // 해당 항공권의 도착 공항을 경로에 추가한다.
            route.add(tickets[i][1]);

            // 도착 공항으로 이동한 뒤, 사용한 항공권 개수를 1 증가시켜 DFS를 계속 진행한다.
            if (dfs(tickets[i][1], usedCount + 1)) {
                return true;
            }

            // 도착 공항 경로에서 제거 - 현재 선택으로는 모든 항공권을 사용할 수 없을 경우
            route.remove(route.size() - 1);
            // 방금 사용 처리한 항공권을 다시 미사용 상태로 되돌린다.
            visited[i] = false;
        }

        // 완성 경로를 만들지 못한 경우.
        return false;
    }
}
