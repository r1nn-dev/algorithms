// Solution2: 카운팅 배열 + 투 포인터 방식

class Solution {
  public int solution(int[] people, int limit) {
    // 몸무게는 40kg 이상 240kg 이하이므로 인덱스를 몸무게로 사용한다.
    int[] count = new int[241];

    // 각 몸무게별 사람 수를 센다.
    for (int weight : people) {
      count[weight]++;
    }

    // 가능한 가장 가벼운 몸무게이다.
    int left = 40;

    // 가능한 가장 무거운 몸무게이다.
    int right = 240;

    // 아직 구출하지 않은 사람 수이다.
    int remaining = people.length;

    // 필요한 구명보트 개수이다.
    int answer = 0;

    // 모든 사람을 구출할 때까지 반복한다.
    while (remaining > 0) {
      // 현재 남아 있는 가장 가벼운 사람의 몸무게를 찾는다.
      while (left <= 240 && count[left] == 0) {
        left++;
      }

      // 현재 남아 있는 가장 무거운 사람의 몸무게를 찾는다.
      while (right >= 40 && count[right] == 0) {
        right--;
      }

      // 가장 무거운 사람을 먼저 보트에 태운다.
      count[right]--;
      remaining--;

      // 보트 하나를 사용한다.
      answer++;

      // 가장 무거운 사람만으로 모든 사람이 처리된 경우이다.
      if (remaining == 0) {
        break;
      }

      // 가장 무거운 사람을 태운 뒤, 다시 남아 있는 가장 가벼운 사람을 찾는다.
      while (left <= 240 && count[left] == 0) {
        left++;
      }

      // 남아 있는 가장 가벼운 사람과 함께 탈 수 있으면 같이 태운다.
      if (left <= right && left + right <= limit) {
        count[left]--;
        remaining--;
      }
    }

    return answer;
  }
}
