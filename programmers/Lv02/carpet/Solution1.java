// Solution1: 약수 쌍 완전탐색 방식 

class Solution {
    public int[] solution(int brown, int yellow) {
        // 전체 카펫의 격자 수 = 갈색 격자 수 + 노란색 격자 수
        int total = brown + yellow;

        // 전체 넓이의 약수 쌍 중에서 세로 길이 후보를 탐색한다.
        // 가로는 세로보다 크거나 같으므로 세로는 sqrt(total)까지만 확인하면 충분하다.
        for (int h = 3; h <= Math.sqrt(total); h++) {
            // h가 전체 넓이의 약수가 아니면 카펫의 세로 길이가 될 수 없다.
            if (total % h != 0) {
                continue;
            }

            // 세로 길이가 정해지면 가로 길이는 자동으로 결정된다.
            int w = total / h;

            // 테두리 1줄을 제외한 내부 영역의 크기가 yellow와 일치하는지 확인한.
            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }
        }

        return new int[]{};     // 문제 조건 - 정답은 항상 존재한다.
    }
}
