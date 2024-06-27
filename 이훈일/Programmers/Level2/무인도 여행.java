import java.util.*;

class Solution {
    int[][] graph;
    boolean[][] visited;
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    int n, m;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        graph = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] land = maps[i].split("");
            
            for(int j = 0; j < m; j++) {
                if(land[j].equals("X")) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.parseInt(land[j]);
                }
            }
        }
        
        visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] > 0 && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }
        
        int[] answer;
        if(result.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[result.size()];
            for(int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        
        int day = 0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            
            day += graph[x][y];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(graph[nx][ny] > 0 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return day;
    }
}
