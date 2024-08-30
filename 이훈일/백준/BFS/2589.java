package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2589 {
    static int N,M;
    static String[][] graph;
    static boolean[][] visited;
    static int result;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[N][];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            graph[i] = line.split("");
        }

        result = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j].equals("L")) {
                    visited = new boolean[N][M];
                    bfs(new int[]{i, j, 0});
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny].equals("L") && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, cur[2] + 1});
                        result = Math.max(result, cur[2] + 1);
                    }
                }
            }
        }
    }
}
