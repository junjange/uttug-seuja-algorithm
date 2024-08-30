import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            String[] graph = places[i];
            boolean isPossible = true;           
            for(int j = 0; j < 5 && isPossible; j++) {
                for(int k = 0; k < 5 && isPossible; k++) {
                    if(graph[j].charAt(k) == 'P') {
                        if(!bfs(j, k, graph)) {
                            isPossible = false;
                        }
                    }
                }
            }
            
            answer[i] = isPossible ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean bfs(int row, int col, String[] graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || (nx == row && ny == col)) {
                    continue;
                }
                
                int d = Math.abs(nx - row) + Math.abs(ny - col);
                    
                if(graph[nx].charAt(ny) == 'P' && d <= 2) {
                    return false;
                } else if(graph[nx].charAt(ny) == 'O' && d < 2) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        return true;
    }
}
