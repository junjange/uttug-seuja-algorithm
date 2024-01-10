import java.lang.Math;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String a = Integer.toString(n, k);
    
        String arr[] = a.split("0");
        
        for(String str: arr){
            
            if(str.equals("")){
                continue;
            }
            
            if(check(Long.parseLong(str))){
                answer++;
            }
            
        }

        
        
        return answer;
    }
    
    public boolean check(long num){
        
        if(num == 1){
            return false;
        }
        
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            
            if(num % i == 0){
                
                return false;
                
            }
            
        }
        
        return true;
        
    }
        
}
