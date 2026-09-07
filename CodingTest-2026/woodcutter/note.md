# Problem: Title of Problem
 
문제 요약: 원형으로 배치된 나무를 이동하며 조건을 만족하는 나무를 벌목하고, 모든 나무가 매 턴 성장할 때 최종 목재량을 구한다.

## 풀이

### 문제 정보
- 난이도: Lv 02 정도 
- 주제: 시뮬레이션, Lazy Update, 원형 배열
- 문제 핵심 
  - 전역 Offset으로 나무의 공통 성장 처리
  - Lazy Update로 O(NQ) → O(N + Q)
  - 원형 배열 인덱스 이동
- 최초 풀이: 260811 
- 수정 버전: 260907

### 접근법
1. Solution1: 전역 성장량을 이용한 Lazy Update
   - 매 턴 모든 나무를 직접 갱신하지 않고 공통 성장량만 누적하여 현재 나무의 높이를 O(1)에 계산한다.

## Solution1: 방식 (권장)
### 코드 설계
1. 실제 코드의 첫 번째 동작
2. 초기화할 변수
3. 반복문 안에서 할 일
   - 조건에 따른 갱신
   - 누적
   - 비교
4. 반환 형식

### Java
- 구현 파일: `Solution1.java`
- 핵심 문법:
  - 예: `BufferedReader`
  - 예: `StringTokenizer`
  - 예: `Math.min()`, `Math.max()`

### Python
- 구현 파일: `Solution1.py`
- 핵심 문법:
  - 예: `input()`
  - 예: `map()`
  - 예: `min()`, `max()`

### 복잡도
- 시간복잡도: 
- 공간복잡도: 
