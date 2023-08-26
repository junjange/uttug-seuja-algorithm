class Solution {
    public int solution(int n) {
        
        int answer = 0;
        int olen = Integer.bitCount(n);
      
        
        for(int i= n+1; ;i++){
            
            int blen = Integer.bitCount(i);
            
            if(blen==olen){
                answer = i;
                break; 
            }
            
            
        }
        return answer;
    }
}
