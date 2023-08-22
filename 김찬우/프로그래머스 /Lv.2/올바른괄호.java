class Solution {
    boolean solution(String s) {
        
        char[] str = s.toCharArray();
        boolean answer = false;
        int cnt = 0;
        for (char c : str) {
            cnt += c == '(' ? 1 : -1;
            if(cnt < 0) return false;
        }
        return cnt == 0;
    }
}
