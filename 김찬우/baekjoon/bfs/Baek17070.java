
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,1};
    static int[] dy = {1,0,1};
    static int result = 0;

    static HashMap<Integer,int[]> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        hashMap.put(0,new int[]{0,2});
        hashMap.put(1,new int[]{1,2});
        hashMap.put(2,new int[]{0,1,2});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,1,0);
        System.out.println(result);
        
    }

    static void dfs(int x , int y, int d) {


        if (x == n-1 && y == n-1) {
            result++;
            return;
        }

        // 다른 종료조건 필요할수도

        int[] arr = hashMap.get(d);

        for (int i=0; i < arr.length; i++) {

            if (arr[i] == 2) {

                boolean check = true;

                for (int j=0; j<3; j++) {

                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || nx >= n || ny <0 || ny >=n || map[nx][ny] !=0) {
                        check = false;
                        break;
                    }

                }

                if (check) {

                    int nx = x + 1;
                    int ny = y + 1;

                    visited[nx][ny] = true;
                    dfs(nx,ny,2);
                    visited[nx][ny] = false;

                }

            }else {

                int nx = x + dx[arr[i]];
                int ny = y + dy[arr[i]];

                if (nx >= 0 && nx < n && ny >=0 && ny <n && map[nx][ny] ==0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx,ny,arr[i]);
                    visited[nx][ny] = false;
                }

            }

        }


    }
}
