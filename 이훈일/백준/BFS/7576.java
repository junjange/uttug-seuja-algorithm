package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
    static int[][] graph;
    static int M,N,answer;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        if(checkAllRipened()) {
            answer = countMax() - 1;
        } else {
            answer = -1;
        }

        System.out.println(answer);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(graph[nx][ny] == 0) {
                        graph[nx][ny] = graph[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static Boolean checkAllRipened() {
        Boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0) {
                    isPossible = false;
                }
            }
        }

        return isPossible;
    }

    public static int countMax() {
        int max = -1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                max = Math.max(max, graph[i][j]);
            }
        }

        return max;
    }
}
