
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};
    static int cnt;



    public static void main(String[] args) {

        // 아이디어
        // 높이가 0 부터 100 까지를 기준으로 하면서 높이가 최대값 이하인 수들의 방문여부를 true로 변환한다.
        // 2중 for을 돌면서 방문 한 적이 없으면 dfs를 돈다. 다 돌고나서 cnt++ 해주고 result 배열에 추가해준다.  마지막으로 가장 큰값을 출력한다.

        // 시간 복잡도
        // 100*100*100 + 100*100*4

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }

        }

        for(int k=0; k<=100; k++){
            cnt=0;
            visited =new boolean[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j]<=k){
                        visited[i][j] =true;
                    }
                }

            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){

                    if(!visited[i][j]){
                        visited[i][j] = true;
                        dfs(i,j);
                        cnt++;

                    }
                }

            }

            result.add(cnt);


        }

        Collections.sort(result);
        System.out.println(result.get(result.size()-1));


    }

    public static void dfs(int x , int y){

        for(int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<n && nx >=0 && ny<n && ny >=0){

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx,ny);
                }

            }



        }

    }
}
