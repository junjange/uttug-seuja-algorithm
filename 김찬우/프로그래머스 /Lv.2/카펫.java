import java.lang.Math;
class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 아이디어 
        // yellow를 한줄 두줄로 해서 전부탐색 
        
        int[] answer = new int[2];
        
        
        for(int i = 1 ; i <= yellow; i++){
            
            if(yellow % i !=0){
                continue;
            }
        
            int x = yellow / i;
            int y = i;
            
            if( (x+2)*2 + y*2 ==  brown){
                
                answer[0] = Math.max(x+2,y+2);
                answer[1] = Math.min(x+2,y+2);
                
            }
            
        }
        
        
        

        return answer;
    }
}

      
