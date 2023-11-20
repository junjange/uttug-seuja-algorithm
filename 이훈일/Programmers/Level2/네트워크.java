class Solution {
    public static int[][] computers;
    public static boolean[] isVisited;
    
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        isVisited = new boolean[n];
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                dfs(i);
                count++;
            }
        }
        
        return count;
    }
    
    public static void dfs(int start) {
        isVisited[start] = true;
        
        for(int i = 0; i < computers.length; i++) {
            if(!isVisited[i] && computers[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
