import java.lang.Math;
class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int start = 0;
        int end = sequence.length-1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int n = sequence.length;
        
        int j = 0;
    
        for(int i = 0; i < n; i++){
    
            
            while(sum < k && j<n){
                sum += sequence[j++];
            
            }
            
            if(sum == k){
                
                int range = j - i - 1;
                
                if((end - start) > range){
                    
                    start = i;
                    end = j-1;
                    
                }
                
            }
            
            sum -= sequence[i];
            
        }
        int[] answer = new int[2];
        
        answer[0] = start;
         answer[1] = end;
        
        return answer;
    }
}
