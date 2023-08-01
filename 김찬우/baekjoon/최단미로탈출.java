import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {


    public static int n,m;
    public static int[][] graph = new int[201][201];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};


    public static int bfs(int x, int y){

        Queue<node> q = new LinkedList<>();

        q.offer(new node(x, y));

        while(!q.isEmpty()){
            node node  = q.poll();
            x= node.getX();
            y= node.getY();

            for(int i =0 ; i<4 ;i++){

                int newDx = x+dx[i];
                int newDy = y+dy[i];

                if(newDx<=-1 || newDx>=n || newDy>=m || newDy<=-1 ){
                    continue;
                }

                if (graph[newDx][newDy] == 0) continue;

                if(graph[newDx][newDy]==1){
                    graph[newDx][newDy] = graph[x][y] + 1;
                    q.offer(new node(newDx,newDy));
                }

            }

        }

        return graph[n - 1][m - 1];

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기


        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(dfs(0, 0));



    }

}



public class node {

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
