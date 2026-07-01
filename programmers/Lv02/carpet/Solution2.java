// Solution2: 노란색 영역 약수 쌍 탐색 방식

class Solution {
    public int[] solution(int brown, int yellow) {
        // 1. 노란색 영역의 세로 길이 후보를 1부터 탐색한다. 
        // 노란색 영역도 직사각형이므로 yellow의 약수 쌍으로 가로와 세로가 결정된다.
        for (int innerH = 1; innerH <= Math.sqrt(yellow); innerH++) {
            // 2. innerH가 yellow의 약수가 아니면 노란색 영역의 세로 길이가 될 수 없다.
            if (yellow % innerH != 0) {
                continue;
            }

            // 3. 노란색 영역의 세로 길이가 정해지면 가로 길이는 자동으로 결정된다. 
            int innerW = yellow / innerH;

            // 4. 노란색 영역의 바깥쪽에 갈색 테두리 1줄을 추가한다. 
            int w = innerW + 2; 
            int h = innerH + 2;
          
            // 5. 전체 카펫 넓이에서 노란색 영역을 빼면 갈색 영역의 개수가 된다.
            int calculatedBrown = w * h - yellow;

            // 6. 계산한 갈색 영역의 개수가 brown과 같으면 정답이다.
            if (calculatedBrown == brown) {
                return new int[]{w, h};
            }
        }

        // 7. 문제 조건상 정답은 항상 존재하지만, 컴파일을 위해 빈 배열을 반환한다.
        return new int[]{};   
    }
}
