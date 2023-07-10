class Solution {
    
    public int solution(int number, int limit, int power) {
        
        int count = 0;
        int result = 0;
        
        for(int i=1; i<=number;i++){
            
            count = 1;
            
            for(int j=1; j<=(i/2) ;j++){
                
                if(i%j==0){
                    count++;
                }
                
            }
            
            if(count>limit){
                result+=power;
            }else{
                result+=count;
            }
            
            
        }
    
        return result;
    }
}
