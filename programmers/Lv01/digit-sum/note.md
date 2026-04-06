# Problem: 자릿수 더하기

주제: 기본 연산   

문제: 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요   
- 제한사항: 0 ≤ n ≤ 1,000,000   
- 입출력 예
  
  ```
  입력: 930211
  출력: 16 (9+3+0+2+1+1)
  ```

- 핵심
  - 숫자를 문자열로 변환하거나, 나머지 연산으로 각 자릿수 추출


### String 변환
1. `charAt(i) - '0’` : ASCII
   
3. `toCharArray()` + `ch - '0'` : 배열 변환 수 for문
4. `Character.getNumericValue()`
5. `Integer.parseInt(String.valueOf(ch))` : char → String → int 이중 변환
