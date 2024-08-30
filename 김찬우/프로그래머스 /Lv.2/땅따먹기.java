import java.util.*;
import java.lang.Math;
class Solution {
    int solution(int[][] land) {

        int[][] dp = new int[land.length][4];
        int max;
        
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        // 아이디어 
        // dp로 전에 있는 값들을 저장 
        
        // 시간 복잡도 100000 * 4  
        
        for(int i=1; i<land.length; i++){
            
            
            for(int j = 0; j<4; j++){
                
                max = 0; 
                
                for(int k=0; k<4; k++){
                    
                    if(k == j){
                        continue;
                    }
                    
                    max = Math.max(max, dp[i-1][k]);
                    
                }
                
                dp[i][j]  = land[i][j] + max;
                
                
            }
            
        }
        
        max =0;

        for(int i=0; i<4; i++){
         
            
            if(dp[land.length-1][i] >= max){
                
                max = dp[land.length-1][i];
                
            }
            
        }

        
        return max;
    }
}
