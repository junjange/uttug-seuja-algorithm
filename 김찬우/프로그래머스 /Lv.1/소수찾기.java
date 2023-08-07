class Solution {
    public int solution(int n) {
        
        int answer = 0;
        boolean check[] = new boolean[n+1];
        
        for(int i=2;i<=n;i++){
            
            if(check[i] == true) continue;
        
            for(int j=i+i; j<=n; j+=i){
                check[j]=true;
            }
            
        }
        
        for(int k =2;k<=n;k++){
            
            if(!check[k]){
                answer++;
            }
        }
        
        
            
         return answer;   
        
    }      
        
}
