// Solution1: 트리 지름 기반 반지름 계산 
import java.io.*;
import java.util.*;

class Main {

    static int N;
    static ArrayList<Edge>[] graph;

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node {
        int number;
        long distance;

        Node(int number, long distance) {
            this.number = number;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            int child = i + 1;

            // 달집 그래프는 무방향 가중치 트리이다.
            graph[parent].add(new Edge(child, length));
            graph[child].add(new Edge(parent, length));
        }

        // 정점이 1개뿐이면 태울 나뭇가지가 없으므로 시간은 0이다.
        if (N == 1) {
            System.out.println(0);
            return;
        }

        // 1번 정점에서 가장 먼 정점을 찾는다.
        Node first = getFarthestNode(1);

        // first에서 가장 먼 정점을 찾으면 트리 지름의 반대쪽 끝점이 된다.
        Node second = getFarthestNode(first.number);

        // 지름의 양 끝점에서 모든 정점까지의 거리를 각각 구한다.
        long[] distFromFirst = getDistances(first.number);
        long[] distFromSecond = getDistances(second.number);

        long answer = Long.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            // i번 달집에서 불을 붙였을 때 가장 늦게 타는 달집까지의 시간이다.
            long burnTime = Math.max(distFromFirst[i], distFromSecond[i]);

            // 모든 시작 달집 중 최소 시간을 구한다.
            answer = Math.min(answer, burnTime);
        }

        System.out.println(answer);
    }

    static Node getFarthestNode(int start) {
        long[] distance = getDistances(start);

        int farthestNode = start;
        long maxDistance = 0;

        for (int i = 1; i <= N; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                farthestNode = i;
            }
        }

        return new Node(farthestNode, maxDistance);
    }

    static long[] getDistances(int start) {
        long[] distance = new long[N + 1];
        boolean[] visited = new boolean[N + 1];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (Edge edge : graph[current]) {
                int next = edge.to;

                if (visited[next]) {
                    continue;
                }

                visited[next] = true;

                // 트리는 경로가 유일하므로 현재 거리에서 간선 길이를 더하면 된다.
                distance[next] = distance[current] + edge.cost;
                stack.push(next);
            }
        }

        return distance;
    }
}
