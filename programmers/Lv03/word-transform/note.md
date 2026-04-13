# Problem: 단어 변환

주제: BFS, 그래프 구축, 최단 경로

문제: begin에서 target으로 변환하는데, words의 단어를 거쳐 한 글자씩만 변환 가능합니다. 최소 변환 횟수를 구하세요.
```
두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

  1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
  2. words에 있는 단어로만 변환할 수 있습니다.

예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면
"hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,
최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
```

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


### 
1.

2. 
3. 
4. 
