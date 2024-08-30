class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[500][500]; 
        
        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[0][0]+triangle[1][0];
        dp[1][1] = triangle[0][0]+triangle[1][1];
        
        for(int i=2; i<triangle.length; i++){
            
            for(int j = 0; j<triangle[i].length; j++){
                
                if(j == 0){
                    
                    if(triangle[i][j] + dp[i-1][j] > dp[i][j]){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                        
                    }
                    
                }else{
                    
                    if(triangle[i][j] + dp[i-1][j-1] > dp[i][j]){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                    }
                    
                    if(triangle[i][j] + dp[i-1][j] > dp[i][j]){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                    }
                    
                }
                
                
                
            }
            
        }

        int len = triangle[triangle.length-1].length;
          
        
        int max = 0;
        for(int i=0; i<len; i++){
            
            if(dp[len-1][i] > max ){
                max = dp[len-1][i];
                answer = max;
            }
            
        }
        
        
        return answer;
    }
}
