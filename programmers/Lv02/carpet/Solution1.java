// Solution1: 전체 넓이 약수 쌍 탐색 방식 (권장)

class Solution {
    public int[] solution(int brown, int yellow) {
        // 1. 전체 카펫의 격자 수를 구한다. 
        // 전체 격자 수 = 갈색 격자 수 + 노란색 격자 수
        int total = brown + yellow;

        // 2. 세로 길이 후보를 3부터 탐색한다. 
        // 카펫은 갈색 테두리 1줄과 내부 노란색 영역을 가져야 하므로 최소 세로 길이는 3이다. 
        // 가로는 세로보다 크거나 같기 때문에 세로 후보는 sqrt(total)까지만 확인하면 된다.
        for (int h = 3; h <= Math.sqrt(total); h++) {
            // 3. h가 전체 넓이의 약수가 아니면 세로 길이가 될 수 없다.
            if (total % h != 0) {
                continue;
            }

            // 4. 세로 길이가 h로 정해지면 가로 길이는 total / h로 결정된다.
            int w = total / h;

            // 5. 갈색 테두리 한 줄을 제외한 내부 노란색 영역의 크기를 계산한다. 
            int innerArea = (w - 2) * (h - 2);

            // 6. 내부 영역의 크기가 yellow와 같으면 조건을 만족하는 카펫이다. 
            if (innerArea == yellow) {
                return new int[]{w, h};
            }
        }

        // 7. 문제 조건상 정답은 항상 존재하지만, 컴파일을 위해 빈 배열을 반환한다.
        return new int[]{};   
    }
}
