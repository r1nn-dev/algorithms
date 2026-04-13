import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words 배열에 있는지 확인
        if (!Arrays.asList(words).contains(target)) {
		        // target이 words 배열에 없으면 변환 자체가 불가능
            return 0;
        }

        Queue<Word> queue = new LinkedList<>();
        // 방문 체크 - 각 단어의 방문 여부를 체크 (중복 탐색 방지)
        boolean[] visited = new boolean[words.length]; // 중복 탐색 방지용 방문 체크

        // 시작 단어를 큐에 삽입하고 BFS 탐색 시작
				// depth = 0 : 아직 변환하지 않은 상태
        queue.offer(new Word(begin, 0));
        
        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            // 현재 탐색 중인 단어
            Word current = queue.poll();

            // target에 도달하면 현재 depth가 최소 변환 횟수
            if (current.word.equals(target)) {
                return current.depth;
            }

            // 현재 단어에서 변환 가능한 다음 단어 탐색
            for (int i = 0; i < words.length; i++) {
                // 아직 방문하지 않았고, 한 글자만 다른 경우 -> 이동 가능
                if (!visited[i] && canChange(current.word, words[i])) {
                    // 방문 처리 
                    visited[i] = true;
                    // 다음 단어를 변환 횟수 +1 상태로 큐에 추가
                    queue.offer(new Word(words[i], current.depth + 1));
                }
            }
        }

        // 끝까지 탐색해도 target에 도달하지 못한 경우 -> 변환 불가능
        return 0;
    }

    // canChange(): 두 단어가 한 글자만 다른지 확인하는 함수
    boolean canChange(String a, String b) {
        int difference = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) difference++;
        }

        // 한 글자만 다르면 변환 가능
        return difference == 1;
    }

    // BFS에서 사용할 데이터 구조 (단어 + 현재까지 변환 횟수)
    static class Word {
        String word;
        int depth;

        Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}
