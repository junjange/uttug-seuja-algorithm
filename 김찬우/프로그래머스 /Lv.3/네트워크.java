class Solution {
    
    static boolean visit[];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visit[i] == false){
                dfs(n,i,computers);
                answer++;
            }
            
        }
        
        return answer;
    }
    
    static void dfs(int n, int i, int[][] computers){
        
        visit[i] = true;
        
        for(int j=0; j<n; j++){
            
            if(i==j){
                continue;
            }
            
            if( visit[j] == false && computers[i][j]==1){
                dfs(n,j,computers);
            }
            
        }
        
        
    }
}
