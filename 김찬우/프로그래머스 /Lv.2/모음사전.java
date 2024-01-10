import java.util.*;

class Solution {
    
    static int sum =0; 
    static StringBuilder sb = new StringBuilder();
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static int result = 0; 
        
    public int solution(String word) {
        // 백트레킹 사용
        // 중복해서 뽑는다. word와 뽑은 단어가 같을 때 끝낸다.
        // 한번 뽑을 때 마다 숫자 +1; 
        
        
        
        dfs(word);
    

        return result;
    }
    
    public void dfs(String word){
        
    
        if(sb.toString().equals(word)){
          
            result = sum;
            return;
        }
        
        
        if(sb.length() ==  5){
            return;
        }
        
        
        
        for(int i=0; i<5; i++){
            
            sb.append(arr[i]);
            sum++;
    
            dfs(word);
         
            
            sb.deleteCharAt(sb.length()-1);
            
        }
        
        
        
    }
}
