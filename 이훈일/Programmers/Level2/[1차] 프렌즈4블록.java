class Solution {
    String[][] graph;
    boolean[][] visited;
    int count;
    int[] dx = new int[]{0, 1, 0, 1};
    int[] dy = new int[]{0, 0, 1, 1};
    
    public int solution(int m, int n, String[] board) {
        graph = new String[m][n];
        for(int i = 0; i < m; i++) {
            graph[i] = board[i].split("");
        }
        
        count = 0;
        int pre = -1;
        while(count != pre) {
            pre = count;
            visited = new boolean[m][n];
            
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(isSame(i, j)) {
                        counting(i, j);
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = m-1; j >= 0; j--) {
                    if(graph[j][i].equals("-") || visited[j][i]) {
                        graph[j][i] = "-";
                        moving(j, i);
                    }             
                }
            }
        }
        
        return count;
    }
    
    public boolean isSame(int x, int y) {
        String start = graph[x][y];
        if(start.equals("-")) {
            return false;
        }
        
        for(int i = 1; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            String comp = graph[nx][ny];
            
            if(!start.equals(comp)) {
                return false;
            }
        }
        
        return true;
    }
    
    public void counting(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
                        
            if(!visited[nx][ny]) {
                visited[nx][ny] = true;
                count++;
            }
        }
    }
    
    public void moving(int x, int y) {
        for(int i = x; i >= 0; i--) {
            if(!graph[i][y].equals("-") && !visited[i][y]) {
                graph[x][y] = graph[i][y];
                graph[i][y] = "-";
                break;
            }
        }
    }
}
