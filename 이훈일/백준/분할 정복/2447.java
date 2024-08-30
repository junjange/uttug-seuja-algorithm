package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2447 {
    static int N;
    static String[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        graph = new String[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = "*";
            }
        }

        partition(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void partition(int x, int y, int size) {
        if(size == 1) {
            return;
        }

        int newSize = size / 3;
        for(int i = x+newSize; i < x + 2 * newSize; i++) {
            for(int j = y+newSize; j < y + 2 * newSize; j++) {
                graph[i][j] = " ";
            }
        }

        for(int i = x; i < x+size; i += newSize) {
            for(int j = y; j < y+size; j += newSize) {
                partition(i, j, newSize);
            }
        }
    }
}
