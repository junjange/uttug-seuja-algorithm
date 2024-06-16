import java.util.*;

class Solution {
    public int solution(int n) {
        long[] answer = new long[100001];
    
        answer[0] = 0;
        answer[1] = 1;
        
        for(int i=2; i <= 100000; i++){
            
            answer[i] = (answer[i-1] + answer[i-2]) % 1234567;
            
        }
   
        

        return (int)answer[n];
    }
}
