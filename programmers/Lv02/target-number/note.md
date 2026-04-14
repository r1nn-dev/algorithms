# Problem: 타겟 넘버

링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

주제: DFS, 재귀, 모든 경로 탐색 

문제: 배열 numbers의 각 숫자 앞에 +, - 중 하나를 선택해서 target을 만드는 경우의 수를 구하세요.

- 제한사항:
  - 주어지는 숫자의 개수는 2개 이상 20개 이하 
  - 각 숫자는 1 이상 50 이하인 자연수 
  - 타겟 넘버는 1 이상 1000 이하인 자연수 
    
- 입출력 예
  
  ```
  numbers: [1, 1, 1, 1, 1]
  target: 3
  return: 5

  numbers: [4, 1, 2, 1]
  target: 4
  return: 2
  ```
  
- 핵심
  - 재귀로 모든 부호 조합 탐색
  - DFS의 기본 형태
  - 시간복잡도: O(2^n)


## 풀이: DFS 완전 탐색
- 핵심
    - `depth`: 현재 처리 중인 숫자의 위치(인덱스)
    - `sum`: 현재까지의 누적합
    - `sum == target`이면 경우의 수 1 증가
- 시간복잡도: O(2^n)
