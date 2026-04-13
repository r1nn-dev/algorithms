class Solution {
    boolean solution(String s) {
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') balance++;
            else if (c == 'y' || c == 'Y') balance--;
        }

        return balance == 0;
    }
}
