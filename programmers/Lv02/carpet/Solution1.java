// Solution1: 약수 쌍 완전탐색 방식 (권장)

class Solution {
    public int[] solution(int brown, int yellow) {
        // 전체 카펫의 격자 수 = 갈색 격자 수 + 노란색 격자 수
        int total = brown + yellow;

        for (int h = 3; h <= Math.sqrt(total); h++) {
            if (total % h != 0) {
                continue;
            }

            int w = total / h;

            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }
        }

        return new int[]{};
    }
}
