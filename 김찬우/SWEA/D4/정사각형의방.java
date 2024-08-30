import java.io.*;
import java.util.*;

public class Solution {

    static int[][] map = new int[1000][1000];
    static int n;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static boolean[][] visited;
    static int cnt = 0;
    static int min = Integer.MAX_VALUE;
    static int maxCnt = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc =1;  tc<=T; tc++) {
            
            min = Integer.MAX_VALUE;
            maxCnt = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());

            n =Integer.parseInt(st.nextToken());

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {

                    map[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            for (int i=0; i<n; i++) {

                for (int j=0; j<n; j++) {

                    int end = map[i][j];
                    visited = new boolean[n][n];

                    if (!visited[i][j]){
                        visited[i][j] = true;
                        cnt = 1 ;
                        dfs(i,j);

                        if (cnt > maxCnt) {
                            maxCnt = cnt;
                            min = end;
                        }
                        else if (cnt == maxCnt) {
                            min = Math.min(min,end);
                        }

                    }

                }
            }

            System.out.println("#"+tc+" "+min+" "+maxCnt);
        }

    }

    static void dfs(int x, int y) {
        
        for (int i=0; i<4; i++ ) {

            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx <n && ny >=0 && ny < n && !visited[nx][ny]) {

                if (map[nx][ny] - map[x][y] == 1) {
                    visited[nx][ny] = true;
                    cnt++;
                    dfs(nx,ny);
                }

            }

        }

    }
}
