// Solution2: 그래프 구축 후 BFS

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;

        // begin까지 포함한 전체 단어 목록을 만든다.
        String[] allWords = new String[n + 1];
        allWords[0] = begin;

        for (int i = 0; i < n; i++) {
            allWords[i + 1] = words[i];
        }

        // target의 인덱스를 찾는다.
        int targetIndex = -1;

        for (int i = 0; i < allWords.length; i++) {
            if (allWords[i].equals(target)) {
                targetIndex = i;
                break;
            }
        }

        // target이 words에 없으면 변환할 수 없다.
        if (targetIndex == -1) {
            return 0;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < allWords.length; i++) {
            graph.add(new ArrayList<>());
        }

        // 한 글자만 다른 단어끼리 양방향 간선을 연결한다.
        for (int i = 0; i < allWords.length; i++) {
            for (int j = i + 1; j < allWords.length; j++) {
                if (canChange(allWords[i], allWords[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        return bfs(graph, targetIndex);
    }

    private int bfs(List<List<Integer>> graph, int targetIndex) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[graph.size()];

        Arrays.fill(distance, -1);

        // 0번 인덱스는 begin이다.
        queue.offer(0);
        distance[0] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == targetIndex) {
                return distance[current];
            }

            for (int next : graph.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        return 0;
    }

    // 두 단어가 정확히 한 글자만 다른지 확인한다.
    private boolean canChange(String a, String b) {
        int difference = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                difference++;
            }

            if (difference > 1) {
                return false;
            }
        }

        return difference == 1;
    }
}

