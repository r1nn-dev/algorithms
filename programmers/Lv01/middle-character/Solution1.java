// Solution1: substring 방식 (권장)

class Solution {
    public String solution(String s) {
        int length = s.length();
        int mid = length / 2;
        
        if (length % 2 == 1) {
            return s.substring(mid, mid + 1);
        }
        
        return s.substring(mid - 1, mid + 1);
    }
}
