
import java.io.*;
import java.util.*;

public class Main {

    static int m,n,h;
    static int cnt = 0;
    static int[][][] map  = new int[100][100][100];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int[] dh = {1,-1};
    static Queue<int[]> queue = new ArrayDeque<>();
    static boolean[][][] visited = new boolean[100][100][100];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for (int i=0; i<h; i++) {

            for (int j =0; j<n; j++) {

                st = new StringTokenizer(br.readLine());

                for (int k=0; k<m; k++) {

                    map[j][k][i] = Integer.parseInt(st.nextToken());

                    if (map[j][k][i] == 1) {
                        queue.offer(new int[] {j,k,i});
                    }

                }
            }

        }


        bfs();


        for (int i=0; i<h; i++) {

            for (int j =0; j<n; j++) {

                for (int k=0; k<m; k++) {

                    if (map[j][k][i] == 0) {
                        System.out.println(-1);
                        return;
                    }

                }
            }

        }

        System.out.println(cnt-1);




    }

    static void bfs() {

        while (!queue.isEmpty()) {


            int len = queue.size();

            for (int i=0; i < len; i++) {

                int[] node = queue.poll();

                int x = node[0];
                int y = node[1];
                int t = node[2];

                visited[x][y][t] = true;

                for (int j=0; j<4; j++) {

                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || nx >=n || ny < 0 || ny >= m) {
                        continue;
                    }

                    if (map[nx][ny][t] == 0 && !visited[nx][ny][t]) {
                        visited[nx][ny][t] = true;
                        map[nx][ny][t] =1;
                        queue.offer(new int[] {nx,ny,t});
                    }

                }

                for (int j=0; j<2; j++) {

                    int nh = t + dh[j];

                    if (nh < 0 || nh >= h) {
                        continue;
                    }

                    if (map[x][y][nh] == 0 && !visited[x][y][nh]) {
                        visited[x][y][nh] = true;
                        map[x][y][nh] =1;
                        queue.offer(new int[] {x,y,nh});
                    }

                }



            }

            cnt++;


        }

    }
}
