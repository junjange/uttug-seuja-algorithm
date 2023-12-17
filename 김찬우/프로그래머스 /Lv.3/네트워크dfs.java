class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
       
        // 아이디어
        // 2중 포문을 만들고 방문하지 않은 노드들을 방문하면서 dfs를 돌고 마지막에 cnt++;
        
        // 시간복잡도 
        // 200*200 + 200*200*200;
        int cnt = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
           
            if(!visited[i]){
                visited[i] = true;
                dfs(i,n,computers);
                cnt++;
            }
        }
        
        return cnt;
        
        
    }
    
    public static void dfs(int node, int n, int[][] computers){
        
        int[] c = computers[node];
        
        for(int i=0; i<c.length; i++){
            
            if(c[i] ==1  && !visited[i]){
                visited[i] =true;
                dfs(i,n,computers);
            }
            
        }
        
    }
}
