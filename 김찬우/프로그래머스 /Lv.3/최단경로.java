import java.util.*;

class Solution {
    
    public static int dx[] = {0,0,-1,1};
    public static int dy[] = {-1,1,0,0};
    

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length-1;
        int m = maps[0].length-1;
        
        answer = bfs(maps,0,0,n,m);
        
        
        if(answer == 1) {
            return -1;
        }
 
        return answer;
    }
    
    static int bfs(int[][] maps, int x, int y,int n, int m){
        
        Queue<Node> qu = new LinkedList<>();
        
        qu.offer(new Node(x,y));
        
        while(!qu.isEmpty()){
            
            Node node = qu.poll();
            x = node.getX();
            y = node.getY();
            
            for(int i=0; i<4; i++){
                
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx > n || ny < 0 || ny > m){
                    continue;
                    
                }
                
                if(maps[nx][ny]==0){
                    continue;
                }
                
                if(maps[nx][ny] == 1){
                    maps[nx][ny] = maps[x][y] + 1;
                    qu.offer(new Node(nx,ny));
                }
                
            }

            
        }
        
        return maps[n][m];
        
    }
}

class Node{
    
    public int x;
    public int y;
    
    public Node(int x, int y){
        
        this.x = x;
        this.y = y;
    
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
}
