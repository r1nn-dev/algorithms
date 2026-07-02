// Solution1: BFS - 변환 가능한 단어를 직접 탐색하는 방식 (권장)

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words 안에 없으면 변환 과정에서 target에 도달할 수 없다.
        if (!containsTarget(words, target)) {
            return 0;
        }

        Queue<State> queue = new ArrayDeque<>();
        // 방문 체크 - 각 단어의 방문 여부를 체크 (중복 탐색 방지)
        boolean[] visited = new boolean[words.length]; // 중복 탐색 방지용 방문 체크

        // 시작 단어를 큐에 삽입하고 BFS 탐색 시작
		// depth = 0 : 아직 변환하지 않은 상태
		// begin은 아직 변환하지 않은 상태이므로 depth는 0이다.
        queue.offer(new State(begin, 0));
        
        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            State current = queue.poll();

            // BFS에서 target에 처음 도달한 순간이 최소 변환 횟수이다.
            if (current.word.equals(target)) {
                return current.depth;
            }

            // 현재 단어에서 변환 가능한 다음 단어를 모두 탐색한다.
            for (int i = 0; i < words.length; i++) {
                // 아직 방문하지 않았고, 한 글자만 다른 경우 -> 이동 가능
                if (!visited[i] && canChange(current.word, words[i])) {
                    // 방문 처리 
                    visited[i] = true;
                    // 다음 단어를 변환 횟수 +1 상태로 큐에 추가
                    queue.offer(new State(words[i], current.depth + 1));
                }
            }
        }

        // 끝까지 탐색해도 target에 도달하지 못한 경우 -> 변환 불가능
        return 0;
    }

    // target이 words 배열 안에 있는지 확인한다.
    private boolean containsTarget(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
				return true;
			}
        }

        return false;
    }

	// 두 단어가 정확히 한 글자만 다른지 확인한다.
    private boolean canChange(String a, String b) {
        int difference = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
				difference++;
			}
			
			// 두 글자 이상 다르면 더 이상 변환 가능한 단어가 아니다. 
			if (difference > 1) { 
				return false; 
			}
        }

        return difference == 1;
    }
	

    // BFS에서 사용할 상태 정보: 현재 단어와 현재까지의 변환 횟수
    static class Word {
        String word;
        int depth;

        Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}

