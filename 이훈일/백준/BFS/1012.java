package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1012 {

    static int[][] graph;
    static boolean[][] visited;
    static int n,m;
    static int k;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new int[m][n];
            visited = new boolean[m][n];

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            count = 0;
            for(int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    if(graph[k][l] == 1 && !visited[k][l]) {
                        bfs(k, l);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            x = point[0];
            y = point[1];
            visited[x][y] = true;

            for(int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx >= 0 && cx < m && cy >= 0 && cy < n) {
                    if(!visited[cx][cy] && graph[cx][cy] == 1) {
                        queue.add(new int[]{cx, cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }
}
