// Solution2: charAt 방식

class Solution {
    public String solution(String s) {
        int length = s.length();
        int mid = length / 2;
        
        if (length % 2 == 1) {
            return String.valueOf(s.charAt(mid));
        }
        
        return "" + s.charAt(mid - 1) + s.charAt(mid);
    }
}
