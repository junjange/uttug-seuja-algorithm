class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        int[][] arr =  new int[n][n];
        
        int x =0;
        int y = 0; 
        int num =1;
        int kind =0;
        for(int i=n-1; i>=0; i--){
            
            if(kind % 3 == 0){
                
                for(int j=0; j<=i; j++){
                    
                    arr[x][y] = num++;
                    x++;
                }
                x--;
                y++;
        
                
            }else if(kind % 3 == 1){
                
                for(int j=0; j<=i; j++){
                    
                    arr[x][y] = num++;
                    y++;
                }
                x--;
                y-=2;
      
                
            }else{
                
                for(int j=0; j<=i; j++){
                    
                    arr[x][y] = num++;
                    x--;
                    y--;
                }
                x+=2;
                y++;
                
            }
            
            kind++;
              
            
        }
        
        int[] result = new int[n*(n+1)/2];
        
        int p = 0;
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<i+1; j++){
                result[p] = arr[i][j];
                p++;
            }
            
        }
        
        
        return result;
    }
}
