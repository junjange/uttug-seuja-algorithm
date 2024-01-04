package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10026 {
    static String[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        N = Integer.parseInt(st.nextToken());
        graph = new String[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "");
            String line = String.valueOf(st.nextToken());
            String[] split = line.split("");
            for(int j = 0; j < N; j++) {
                graph[i][j] = split[j];
            }
        }

        int RGCount = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfsRG(i, j);
                    RGCount++;
                }
            }
        }

        visited = new boolean[N][N];
        int NCount = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfsN(i, j);
                    NCount++;
                }
            }
        }

        System.out.printf("%d %d", RGCount, NCount);
    }

    public static void dfsRG(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && graph[nx][ny].equals(graph[x][y])) {
                    visited[nx][ny] = true;
                    dfsRG(nx, ny);
                }
            }
        }
    }

    public static void dfsN(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if (graph[x][y].equals("B")) {
                    if (graph[nx][ny].equals("B")) {
                        visited[nx][ny] = true;
                        dfsN(nx, ny);
                    }
                } else {
                    if (!graph[nx][ny].equals("B")) {
                        visited[nx][ny] = true;
                        dfsN(nx, ny);
                    }
                }
            }
        }
    }
}
