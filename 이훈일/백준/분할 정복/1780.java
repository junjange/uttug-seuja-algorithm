package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1780 {
    static int N;
    static int[][] graph;
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        for(int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }

    }

    public static void partition(int x, int y, int size) {
        if(isPossible(x, y, size)) {
            if(graph[x][y] == -1) {
                count[0]++;
            } else if(graph[x][y] == 0) {
                count[1]++;
            } else if(graph[x][y] == 1) {
                count[2]++;
            }
            return;
        }

        int nSize = size / 3;

        for(int i = x; i < x + size; i += nSize) {
            for(int j = y; j < y + size; j += nSize) {
                partition(i, j, nSize);
            }
        }
    }

    public static boolean isPossible(int x, int y, int size) {
        int start = graph[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(graph[i][j] != start) {
                    return false;
                }
            }
        }

        return true;
    }
}
