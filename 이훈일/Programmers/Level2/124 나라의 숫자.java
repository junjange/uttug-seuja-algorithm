class Solution {
    public String solution(int n) {
        String[] language = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0) {
            int remain = n % 3;
            n = n / 3;
            
            if(remain == 0) {
                n--;
            }
            
            answer = language[remain] + answer;
        }
        
        return answer;
    }
}
