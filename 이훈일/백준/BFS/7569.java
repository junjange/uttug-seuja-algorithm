package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7569 {
    static int H, N, M, answer;
    static int[][][] graph;
    static Queue<int[]> queue;
    static int[] dz = new int[]{-1, 1, 0, 0, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][N][M];
        queue = new LinkedList<>();
        for(int k = 0; k < H; k++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < M; j++) {
                    graph[k][i][j] = Integer.parseInt(st.nextToken());
                    if(graph[k][i][j] == 1) {
                        queue.add(new int[]{k, i, j, 0});
                    }
                }
            }
        }

        answer = 0;
        bfs();

        if(hasZero()) {
            answer = -1;
        }

        System.out.println(answer);
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int z = point[0];
            int x = point[1];
            int y = point[2];
            int count = point[3];

            for(int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nz >= 0 && nx >= 0 && ny >= 0 && nz < H && nx < N && ny < M) {
                    if(graph[nz][nx][ny] == 0) {
                        graph[nz][nx][ny] = 1;
                        queue.add(new int[]{nz, nx, ny, count+1});
                        answer = Math.max(answer, count+1);
                    }
                }
            }
        }
    }

    public static boolean hasZero() {
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(graph[k][i][j] == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
