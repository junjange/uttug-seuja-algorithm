import java.lang.Math;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int count =0;
        int[] result = new int[n];
        
        Arrays.fill(result,1);
    
        
        for(int i = 0;i<lost.length;i++ ){
            
            int a = lost[i];
            result[a-1]-=1;   
        }
        
         for(int j = 0;j<reserve.length;j++ ){
             
            int b = reserve[j];
            result[b-1]+=1; 
              
        }
        
          for(int k = 0;k<n;k++ ){
             
            if(result[k]==0){
                
                if(k==0){
                    
                    if(result[k+1]==2){
                        result[k+1]=1;
                        result[k]=1;
                    }
                    
                    
                }
                else if(k==(n-1)){
                    
                    if(result[k-1]==2){
                        result[k-1]=1;
                        result[k]=1;
                    }
                    
                }else{
                    if(result[k-1]==2){
                        result[k-1]=1;
                        result[k]=1;
                    }else if(result[k+1]==2){
                        result[k+1]=1;
                        result[k]=1;
                    }
                    
                }
                
            }
              
        }
        
        for(int answer: result){
            if(answer>=1){
                count+=1;
            }
        }
        
    

        return count;
    }
}
