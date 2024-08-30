package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1992 {
    static int N;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "");
            String[] split = st.nextToken().split("");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(split[j]);
            }
        }

        partition(0, 0, N);
        System.out.println(sb);
    }

    public static void partition(int x, int y, int size) {
        if(isPossible(x, y, size)) {
            sb.append(graph[x][y]);
            return;
        }

        int nsize = size / 2;

        sb.append("(");

        partition(x, y, nsize);
        partition(x, y+nsize, nsize);
        partition(x+nsize, y, nsize);
        partition(x+nsize, y+nsize, nsize);

        sb.append(")");
    }

    public static boolean isPossible(int x, int y, int size) {
        int start = graph[x][y];

        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(graph[i][j] != start) {
                    return false;
                }
            }
        }

        return true;
    }
}
