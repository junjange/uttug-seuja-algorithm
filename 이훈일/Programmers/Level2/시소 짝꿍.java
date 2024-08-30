import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        
        int[] count = new int[weights[weights.length-1] * 4 + 1];
        long answer = 0;
        
        for(int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            
            if(count[weight * 4] > 0) {
                answer += count[weight * 4];
            } 
                
            for(int seat = 2; seat <= 4; seat++) {
                answer += count[weight * seat];
            }
            
            answer -= count[weight * 4] * 3;
            
            for(int seat = 2; seat <= 4; seat++) {
                count[weight * seat] += 1;
            }
        }
        
        return answer;
    }
}
