
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] arr;
    static boolean[][] visited;

    static int each;

    static int n;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) {

        // 아이디어
        // 2중 포문을 만들고 돈다. arr[][] ==1 && visited[][] == false 이면 방문처리 후 dfs를 돈다. 노드를 갈떄 마다 결과를 초기화 해준다.

        // 시간 복잡도 25*25 +25*25*4

        //arr[][]
        //visited[][]
        // each

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++){

            String next = sc.next();
            for (int j=0; j<n; j++){
                arr[i][j] = next.charAt(j)-'0';

            }

        }

        for(int i=0; i<n; i++){

            for (int j=0; j<n; j++){

                if(arr[i][j] == 1 && !visited[i][j]){
                    each = 0;
                    visited[i][j] = true;
                    dfs(i,j);
                    result.add(each);
                }

            }

        }

        System.out.println(result.size());
        Collections.sort(result);
        for(Integer num : result){
            System.out.println(num);
        }






    }

    public static void dfs(int x , int y){

        each++;

        for(int i=0; i<4; i++){

            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx < n && nx>=0 && ny < n && ny >=0){

                if (arr[nx][ny] ==1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    dfs(nx,ny);
                }
            }

        }



    }
}
