import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;

    static int m;
    static int n;
    static int[]dx  = {1,-1,0,0};
    static int[]dy  = {0,0,1,-1};

    //아이디어
    // 2중 for을 돌면서 1 && visited == false--> bfs()
    // bfs 돌면서 cnt+1, 다 돌면 최대값을 갱신

    // 시간 복잡도
    // bfs(노드 + 간선)  ->  (500*500)+(500*500*4) = 1250000 < 2억

    //자료구조
    // int[][] 2차원 배열
    // boolean[][]  방문여부 visited
    // queue

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         m = sc.nextInt();
         n = sc.nextInt();
        int cnt = 0;
        int maxResult = 0;

        visited = new boolean[m][n];
        arr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }

        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1 && visited[i][j] == false){
                    visited[i][j] = true;
                    cnt++;
                    maxResult = Math.max(maxResult,bfs(i,j));
                }
            }

        }

        System.out.println(cnt);
        System.out.println(maxResult);

    }

    static int bfs(int x , int y){

        int result = 1;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){

            int[] node = queue.poll();
            x = node[0];
            y = node[1];

            for(int i=0; i<4; i++){

                int newX = x+ dx[i];
                int newY = y+ dy[i];

                if (newX>=m || newX<=-1 || newY>=n || newY<=-1){
                    continue;
                }

                if(arr[newX][newY] ==1 && visited[newX][newY] == false){
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX,newY});
                    result++;
                }
            }


        }
        return result;

    }


}
