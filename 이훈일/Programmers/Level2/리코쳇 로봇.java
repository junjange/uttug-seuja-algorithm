import java.util.*;

class Solution {
    static String[][] graph;
    static boolean[][] visited;
    static int n, m, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        graph = new String[n][m];
        int[] start = new int[3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i][j] = String.valueOf(board[i].charAt(j));
                
                if(graph[i][j].equals("R")) {
                    start[0] = i;
                    start[1] = j;
                    start[2] = 0;
                }
            }
        }
        
        visited = new boolean[n][m];
        answer = Integer.MAX_VALUE;
        bfs(start);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int weight = node[2];
            
            for(int i = 0; i < 4; i++) {
                int[] mNode = move(x, y, i);
                int nx = mNode[0];
                int ny = mNode[1];
                
                if(graph[nx][ny].equals("G")) {
                    answer = Math.min(answer, weight + 1);
                } else { 
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, weight + 1});
                    }
                }
            }
        }
    }
    
    public static int[] move(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        
        while(true) {
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                break;
            } 
            
            if(graph[nx][ny].equals("D")) {
                break;   
            }
            
            x = nx;
            y = ny;
            
            nx += dx[dir];
            ny += dy[dir];
        }
        
        return new int[]{x, y};
    }
}
