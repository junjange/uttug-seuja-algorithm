package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon11403 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph[i] = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    graph[i].add(j);
                }
            }
        }

        visited = new int[N][N];
        for(int i = 0; i < N; i++) {
            bfs(i);
        }

        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < N; j++) {
                sb.append(visited[i][j] + " ");
            }

            System.out.println(sb.toString());
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nodes = graph[cur];

            for(int node : nodes) {
                if(visited[start][node] == 0) {
                    visited[start][node] = 1;
                    queue.add(node);
                }
            }
        }
    }
}
