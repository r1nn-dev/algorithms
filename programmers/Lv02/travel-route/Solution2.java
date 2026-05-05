// 우선순위 큐 + DFS 방식 

import java.util.*;

class Solution {
    // 출발 공항별 도착 공항 목록을 저장하는 그래프
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    // 최종 경로를 저장하는 리스트 LinkedList - 앞쪽에 공항을 추가
    private LinkedList<String> route = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        // 항공권 정보를 그래프로 변환한다.
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            // from 공항이 아직 graph에 없다면 PriorityQueue를 새로 만든다.
            graph.putIfAbsent(from, new PriorityQueue<>());

            // 해당 출발 공항에서 갈 수 있는 도착 공항을 추가한다.
            // PriorityQueue이므로 알파벳 순으로 가장 앞서는 공항이 먼저 나온다.
            graph.get(from).offer(to);
        }

        // 여행은 항상 ICN에서 시작한다.
        dfs("ICN");

        // LinkedList<String>을 String[]로 변환하여 반환한다.
        return route.toArray(new String[0]);
    }


    // DFS 
    private void dfs(String currentAirport) {
        // 현재 공항에서 출발할 수 있는 도착 공항 목록을 가져온다.
        PriorityQueue<String> destinations = graph.get(currentAirport);

        // 반복문 - 현재 공항에서 아직 사용하지 않은 항공권이 남아 있는 동안 계속 이동한다.
        while (destinations != null && !destinations.isEmpty()) {
            // 알파벳 순으로 가장 앞서는 도착 공항을 꺼낸다.
            // poll()로 꺼낸 순간 해당 항공권은 사용된 것으로 처리된다.
            String nextAirport = destinations.poll();

            // 다음 공항으로 이동한다.
            dfs(nextAirport);
        }

        // 현재 공항에서 더 이상 나갈 항공권이 없으면 경로의 앞쪽에 추가한다.
        // 재귀가 끝나는 순서대로 앞에 붙이면 전체 여행 경로가 완성된다.
        route.addFirst(currentAirport);
    }
}
