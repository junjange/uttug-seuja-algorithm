import java.util.*;
class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        arr = maps;
        
        int len1 = arr.length-1;
        int len2 =  arr[0].length-1;
        visited = new boolean[len1+1][len2+1];
        
        bfs(0,0);
        
    
        
        if (arr[len1][len2] == 1) {
            return -1;
        }
        
        
        
        return arr[len1][len2];
    }
    
    static void bfs(int x, int y) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        visited[x][y] =true;
  
        while (!queue.isEmpty()) {
            
            int[] node = queue.poll();
            
            x = node[0];
            y = node[1];
            
            for (int i=0; i<4; i++) {
                
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >=arr.length || ny < 0 || ny >= arr[0].length) {
                    continue;
                }
                
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                   
                    visited[nx][ny] =true;
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }
            
            
        }
        
        
        
        
    }
}
