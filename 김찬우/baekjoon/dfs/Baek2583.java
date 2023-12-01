
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int m,n,k;

    static int cnt;

    static int[]dx ={1,-1,0,0};
    static int[]dy ={0,0,1,-1};


    public static void main(String[] args) {

        // 아이디어
        // x 최소값 y최소값 x 최대값 최대값 for 뭉을 돌면서 2차원 영역에 visited를 true 선언 하고 2중 for문을 돌면서 방문하지 않은 곳 dfs() cnt++, 리스트에 넣고 마지막에 출력

        // 시간 복잡도
        // 100*100*100*5

        Scanner sc = new Scanner(System.in);

        m= sc.nextInt();
        n= sc.nextInt();
        k= sc.nextInt();

        arr = new int[n][m];
        visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();


        for (int p=0; p<k; p++){

            int x1= sc.nextInt();
            int y1= sc.nextInt();
            int x2= sc.nextInt();
            int y2= sc.nextInt();

            int x_max = Math.max(x1,x2);
            int x_min = Math.min(x1,x2);
            int y_max = Math.max(y1,y2);
            int y_min = Math.min(y1,y2);

            for(int i = x_min; i< x_max; i++){
                for (int j=y_min; j<y_max; j++){
                    visited[i][j] = true;
                }


            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]){
                    cnt = 0;
                    visited[i][j] =true;
                    dfs(i,j);
                    result.add(cnt);
                }

            }

        }

        System.out.println(result.size());
        Collections.sort(result);
        for(Integer num :result){
            System.out.println(num);
        }


    }

    static void dfs(int x, int y){

        cnt++;

        for(int i=0; i<4; i++){

            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<n && nx>=0 && ny<m && ny>=0){

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx,ny);
                }

            }

        }

    }
}
