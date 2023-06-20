class Solution {
    public int solution(int n) {
        
        int answer =0;
        int i =1;
        int j =1;
        
        while(j<=n){
            
            if(i%3==0 || String.valueOf(i).contains("3")){
                
                i++;
                answer = i;
                
            }
            else{
                answer=i;
                i++;
                j++;
            }
            
            
        }
        
        
        return answer;
    }
}
