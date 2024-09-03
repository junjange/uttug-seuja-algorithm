package study.algorithm.swea;

import java.io.*;
import java.util.*;

public class 홈방범서비스 {

    static int[][] map;
    static boolean[][] visited;
    static int n,m;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,-1,0,1};
    static int k;
    static int homeCnt;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (n % 2 == 0) {
                k = n+1;
            }else {
                k = n;
            }

            for (int z = k; z >= 1; z--) {

                int operFee = z*z + (z-1)*(z-1);

                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++) {

                        homeCnt = 0;
                        if (map[i][j] == 1) {
                            homeCnt++;
                        }

                        visited = new boolean[n][n];
                        bfs(i,j,z);

                        if (homeCnt * m > operFee) {
                            max = Math.max(max, homeCnt);
                        }

                    }

                }
            }

            System.out.println("#"+test_case+" " + max);
        }
    }

    static void bfs(int x, int y, int num) {

        visited[x][y] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        for (int i = 0; i<num-1; i++) {

            int len = queue.size();

            for (int j = 0; j < len; j++) {

                int[] node = queue.poll();

                x = node[0];
                y = node[1];

                for (int r = 0; r < 4; r++) {

                    int nx = x + dx[r];
                    int ny = y + dy[r];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;

                        if (map[nx][ny] == 1) {
                            homeCnt++;
                        }

                        queue.offer(new int[]{nx, ny});

                    }

                }

            }

        }

    }
}
