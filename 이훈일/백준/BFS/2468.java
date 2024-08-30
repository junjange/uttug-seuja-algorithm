package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2468 {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int max_height = 0;
    static int max_count = 0;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(max_height, graph[i][j]);
            }
        }

        for(int height = 0; height <= max_height; height++) {
            visited = new boolean[N][N];
            int count = 0;
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > height && !visited[i][j]) {
                        count++;
                        bfs(i, j, height);
                    }
                }
            }
            max_count = Math.max(max_count, count);
        }

        System.out.println(max_count);
    }

    public static void bfs(int row, int col, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(graph[nx][ny] > height && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
