import java.util.*;
class Solution {
    
    static int[][] arr1;
    static int[][] arr2;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    static int startX;
    static int startY;
    
    static int leverX;
    static int leverY;
    
    static int endX;
    static int endY;
    
    public int solution(String[] maps) {
        arr1 = new int[maps.length][maps[0].length()];
        arr2 = new int[maps.length][maps[0].length()];
        
        for (int i=0; i < maps.length; i++) {
            
            for (int j=0; j < maps[0].length(); j++ ) {
                
                if (maps[i].charAt(j) == 'X') {
                    arr1[i][j] = 0;
                    arr2[i][j] = 0;
                    
                }else if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    arr1[i][j] = 1;
                    arr2[i][j] = 1;
                }else if (maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                    arr1[i][j] = 1;
                    arr2[i][j] = 1;
                    
                }else if (maps[i].charAt(j) == 'E') {
                    endX = i;
                    endY = j;
                    arr1[i][j] = 1;
                    arr2[i][j] = 1;
                    
                }else {
                    arr1[i][j] = 1;
                    arr2[i][j] = 1;
                }
                
            }
            
        }
        
        bfs(arr1, startX,startY);
        
        
        if (arr1[leverX][leverY] == 1) {
            return -1;
        }
        
        bfs(arr2, leverX,leverY);
        
        
        if (arr2[endX][endY] == 1) {
            return -1;
        }
        

        int answer = arr2[endX][endY] + arr1[leverX][leverY]-2;
        
        return answer;
    }
    
    static void bfs(int[][] arr, int x , int y) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{x,y});
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            
            x= node[0];
            y= node[1];
            
            for (int i=0; i<4; i++) {
                
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= arr.length || ny <0 || ny >= arr[0].length) {
                    continue;
                    
                }
                
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new int[]{nx,ny});
                }
                
            }
        }
        
       
        
    }
    
}
