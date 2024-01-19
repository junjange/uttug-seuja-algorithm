package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GarageGame {
    static int N;
    static int[][] graph;
    static int max = Integer.MIN_VALUE;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new int[3*N][N];
        for(int i = 0; i < 3*N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                graph[3*N-i-1][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] garage = new int[N][N];
        int[] position = new int[N];
        dfs(0, 0, garage, position, 0, N-1, 0, N-1);

        System.out.println(max);
    }

    public static void dfs(int depth, int score, int[][] garage, int[] position, int l, int r, int b, int t) {
        if(depth == 3) {
            max = Math.max(score, max);
            return;
        }

        makeGarage(l, r, b, t, garage, position);

        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    int[] result = bfs(i, j, visited, garage);
                    dfs(depth + 1, score + result[0], garage, position, result[1], result[2], result[3], result[4]);
                }
            }
        }
    }

    public static void makeGarage(int l, int r, int b, int t, int[][] garage, int[] position) {
        for(int j = l; j <= r; j++) {
            for(int i = b; i <= t; i++) {
                if(garage[i][j] == 0) {
                    garage[i][j] = graph[position[j]][j];
                    position[j]++;
                }
            }
        }
    }

    public static int[] bfs(int row, int col, boolean[][] visited, int[][] garage) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        int l = N;
        int r = 0;
        int b = N;
        int t = 0;
        int count = 1;
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            l = Math.min(l, x);
            r = Math.max(r, x);
            b = Math.min(b, y);
            t = Math.max(t, y);
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(!visited[nx][ny] && garage[x][y] == garage[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        count++;
                        visited[nx][ny] = true;
                        garage[nx][ny] = 0;
                    }
                }
            }
        }

        return new int[]{((r-l) * (t-b)) + count, l, r, b, t};
    }
}
