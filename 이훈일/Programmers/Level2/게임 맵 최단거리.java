import java.util.*;

class Solution {
    static int[][] answer;
    static int[][] maps;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        answer = new int[n][m];
        this.maps = maps;
        
        bfs(0, 0);
        
        if(answer[n - 1][m - 1] == 0) {
            return -1;
        } else {
            return answer[n - 1][m - 1];
        }
    }
    
    public static void bfs(int x, int y) {
        answer[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int curX = current[0];
            int curY = current[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                if(maps[nx][ny] == 1 && answer[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    answer[nx][ny] = answer[curX][curY] + 1;
                }
            }
        }
    }
}
