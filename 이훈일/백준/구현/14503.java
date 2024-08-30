package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14503 {
    static int N, M;
    static int r, c, d, count;
    static int[][] graph;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;
        graph[r][c] = 2;
        while(true) {
            if(hasBlank()) {
                advance();
            } else {
                if(isStop()) {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    public static void advance() {
        int curD = (d + 3) % 4;
        int round = 0;

        while(round < 4) {
            int nx = r + dx[curD];
            int ny = c + dy[curD];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0) {
                d = curD;
                r = nx;
                c = ny;
                graph[nx][ny] = 2;
                count++;
                break;
            }
            curD = (curD + 3) % 4;
            round++;
        }
    }

    public static boolean hasBlank() {
        for(int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStop() {
        int newD = (d + 2) % 4;
        int nx = r + dx[newD];
        int ny = c + dy[newD];
        if(nx < 0 || nx >= N || ny < 0 || ny >= M || graph[nx][ny] == 1) {
            return true;
        }
        r = nx;
        c = ny;
        return false;
    }
}
