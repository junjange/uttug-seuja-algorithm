class Solution {
    int[][] graph = new int[11][11];
    boolean[][][] visited = new boolean[11][11][4];
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    
    public int solution(String dirs) {
        String[] dirsSplit = dirs.split("");
        int x = 5;
        int y = 5;
        int count = 0;
        
        for(String dir : dirsSplit) {
            int index = 0;
            
            if(dir.equals("U")) {
                index = 0;    
            } else if (dir.equals("R")) {
                index = 1;
            } else if (dir.equals("D")) {
                index = 2;
            } else if (dir.equals("L")) {
                index = 3;
            }
            
            int nx = x + dx[index];
            int ny = y + dy[index];
            
            if(nx >= 0 && nx < 11 && ny >= 0 && ny < 11) {
                if(!visited[x][y][index]) {
                    count++;
                    visited[x][y][index] = true;
                    visited[nx][ny][(index+2)%4] = true;
                }
                
                x = nx;
                y = ny;
            }
        }
        
        return count;
    }
}
