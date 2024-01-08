package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2630 {
    static int N;
    static int[][] graph;
    static int blueCount = 0;
    static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    public static void partition(int x, int y, int size) {
        if(colorCheck(x, y, size)) {
            if(graph[x][y] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int half = size / 2;
        partition(x, y, half);
        partition(x, y + half, half);
        partition(x + half, y + half, half);
        partition(x + half, y, half);
    }

    public static boolean colorCheck(int x, int y, int size) {
        int color = graph[x][y];

        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(graph[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
