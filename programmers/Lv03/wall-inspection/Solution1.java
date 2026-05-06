// Solution1: 원형 배열 펼치기 + 순열 완전탐색 방식

import java.util.*;

class Solution {
    // dist 배열의 모든 순열 - 친구들의 모든 이동 순서
    private List<int[]> permutations = new ArrayList<>();

    public int solution(int n, int[] weak, int[] dist) {
        int weakCount = weak.length;
        int friendCount = dist.length;

        // 원형 외벽을 일자 배열처럼 처리하기 위해 weak 배열을 2배로 확장한다.
        int[] arrWeak = new int[weakCount * 2];

        for (int i = 0; i < weakCount; i++) {
            // 앞쪽에는 원래 취약 지점을 그대로 저장한다.
            arrWeak[i] = weak[i];
            // 뒤쪽에는 한 바퀴 돈 위치를 저장한다.
            arrWeak[i + weakCount] = weak[i] + n;
        }

        // 친구들의 모든 투입 순서 
        makePermutations(dist, new boolean[friendCount], new int[friendCount], 0);

        // 필요한 친구 수의 최솟값을 저장한다.
        int answer = friendCount + 1;

        // 시작할 취약 지점 구하기 
        // 반복문 - 모두 시도한다.
        for (int start = 0; start < weakCount; start++) {

            // 반복문 - 친구들의 모든 투입 순서를 하나씩 검사한다.
            for (int[] order : permutations) {

                // 첫 번째 친구부터 투입 
                int usedFriend = 1;

                // 현재 친구가 점검할 수 있는 마지막 위치 계산: 시작 취약 지점 + 현재 친구의 이동 가능 거리
                int coverage = arrWeak[start] + order[usedFriend - 1];

                // start부터 weakCount개의 취약 지점을 확인한다.
                for (int index = start; index < start + weakCount; index++) {

                    // 현재 취약 지점이 현재 친구의 점검 가능 범위를 벗어난 경우
                    if (arrWeak[index] > coverage) {
                        // 다음 친구 투입 
                        usedFriend++;

                        // 모든 친구를 다 써도 부족한 경우 -> 더 이상 검사할 필요가 없다.
                        if (usedFriend > friendCount) {
                            break;
                        }

                        // 새로운 coverage = 현재 취약 지점 + 새 친구의 이동 가능 거리 
                        coverage = arrWeak[index] + order[usedFriend - 1];
                    }
                }

                // 현재 시작점과 친구 순서로 모든 취약 지점을 점검할 수 있는 경우에만 최솟값을 갱신한다.
                if (usedFriend <= friendCount) {
                    answer = Math.min(answer, usedFriend);
                }
            }
        }

        // 모든 친구를 투입해도 점검할 수 없는 경우
        if (answer == friendCount + 1) {
            return -1;
        }

        return answer;
    }

    private void makePermutations(int[] dist, boolean[] visited, int[] result, int depth) {
        // 순열의 길이가 dist 길이와 같아지면 -> 하나의 순열 완성 
        if (depth == dist.length) {
            // result 배열의 복사본 -> 재사용
            permutations.add(result.clone());
            return;
        }

        // 아직 사용하지 않은 친구를 한 명씩 선택한다.
        for (int i = 0; i < dist.length; i++) {
            // 이미 현재 순열에 사용한 친구라면 건너뛴다.
            if (visited[i]) {
                continue;
            }

            // i번째 친구를 현재 위치 depth에 배치한다.
            visited[i] = true;
            result[depth] = dist[i];

            // 재귀 호출 - 다음 위치를 채운다.
            makePermutations(dist, visited, result, depth + 1);

            // 다른 순열을 만들기 위해 선택을 되돌린다.
            visited[i] = false;
        }
    }
}
