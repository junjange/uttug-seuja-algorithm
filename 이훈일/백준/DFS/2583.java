package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2583 {
    static int N, M, K, count;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;

            for(int j = startX; j <= endX; j++) {
                for(int k = startY; k <= endY; k++) {
                    graph[j][k] = 1;
                }
            }
        }

        visited = new boolean[M][N];
        int answer = 0;
        List<Integer> areas = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 0 && !visited[i][j]) {
                    count = 0;
                    visited[i][j] = true;
                    dfs(i, j);
                    areas.add(count);
                    answer++;
                }
            }
        }

        Collections.sort(areas);

        StringBuilder sb = new StringBuilder();
        for(int area : areas) {
            sb.append(area + " ");
        }

        System.out.println(answer);
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y) {
        count++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if(!visited[nx][ny] && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}
