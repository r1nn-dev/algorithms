# Problem: 단어 변환

링크: https://school.programmers.co.kr/learn/courses/30/lessons/43163

주제: BFS, 그래프 구축, 최단 경로

문제: begin에서 target으로 변환하는데, words의 단어를 거쳐 한 글자씩만 변환 가능합니다. 최소 변환 횟수를 구하세요.

- 제한사항:
  - 각 단어는 알파벳 소문자로만 이루어져 있다.
  - 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같다.
  - words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없다.
  - begin과 target은 같지 않다.
  - 변환할 수 없는 경우에는 0를 return 한다.
    
- 입출력 예
  
  ```
  begin: "hit", target: "cog"
  words: ["hot", "dot", "dog", "lot", "log", "cog"]
  경로: hit → hot → dot → dog → cog
  return: 4

  begin: "hit", target: "cog"
  words: ["hot", "dot", "dog", "lot", "log"]
  return: 0
  ```

- 핵심
  - 한 글자 차이 나는 단어들을 간선으로 연결 (그래프 구축)
  - BFS로 최단 경로 찾기
  - 그래프 구축 방법이 핵심


## 풀이
### 방법1: BFS
- 핵심
    - 처음 도달한 경로가 최단 경로 → BFS
- 시간복잡도: O(n^2 * m)
    - `n`: 단어 개수
    - `m`: 단어 길이

