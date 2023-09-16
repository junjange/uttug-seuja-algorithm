import java.util.*;
class Solution {
    
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
        
    
    public int solution(int m, int n, int[][] puddles) {
        
        int arr[][] = new int[101][101];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(arr[i], 1);
        
        
        for(int i=0; i<puddles.length;i++){
            
            arr[puddles[i][0]-1][puddles[i][1]-1] = 0;
        }
        
        
        return bfs(0,0,arr,m,n);


    }
    
    
    public static int bfs(int x, int y ,int[][] arr ,int m ,int n){

        Queue<node> q = new LinkedList<>();

        q.offer(new node(x, y));

        while(!q.isEmpty()){
            node node  = q.poll();
            x= node.getX();
            y= node.getY();

            for(int i = 0 ; i<4 ;i++){

                int newDx = x+dx[i];
                int newDy = y+dy[i];

                if(newDx<=-1 || newDx>=n || newDy>=m || newDy<=-1 ){
                    continue;
                }

                if (arr[newDx][newDy] == 0) continue;

                if(arr[newDx][newDy]==1){
                    arr[newDx][newDy] = arr[x][y] + 1;
                    q.offer(new node(newDx,newDy));
                }

            }

        }

        return (arr[n-1][m-1]-2) % 1000000007;

    }
    
    
    
}


class node {

    private int x;
    private int y;

    public node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
