package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14502 {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static Queue<int[]> viruses = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if(depth == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(depth + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        visited = new boolean[N][M];
        Queue<int[]> nViruses = new LinkedList<>(viruses);
        while (!nViruses.isEmpty()) {
            int[] virus = nViruses.poll();
            int x = virus[0];
            int y = virus[1];
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(graph[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        nViruses.add(new int[]{nx, ny});
                    }
                }
            }
        }

        calSafeCount();
    }

    public static void calSafeCount() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    count++;
                }
            }
        }

        max = Math.max(count, max);
    }
}
