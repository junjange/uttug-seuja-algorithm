import java.util.*;

class Solution {
    String[][] graph;
    int n, m;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        int[] lever = new int[2];
        int[] exit = new int[2];
        int[] start = new int[2];
        
        graph = new String[n][m];
        for(int i = 0; i < n; i++) {
            String[] line = maps[i].split("");
            
            for(int j = 0; j < m; j++) {
                if(line[j].equals("L")) {
                    lever[0] = i;
                    lever[1] = j;
                    graph[i][j] = "O";
                } else if(line[j].equals("E")) {
                    exit[0] = i;
                    exit[1] = j;
                    graph[i][j] = "O";
                } else if(line[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                    graph[i][j] = "O";
                } else {
                    graph[i][j] = line[j];
                }
            }
        }
        
        int total = 0;
        
        int first = bfs(start, lever);
        if(first != 0) {
            total += first;
            int second = bfs(lever, exit);
            
            if(second != 0) {
                total += second;
            } else {
                total = 0;
            }
        }
        
        return total == 0 ? -1 : total;
    }
    
    public int bfs(int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        
        visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int sum = node[2];
            
            if(x == end[0] && y == end[1]) {
                return sum;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(graph[nx][ny].equals("O") && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny, sum+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return 0;
    }
}
