import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static List<Edge>[] graph;
    static boolean[] visited;
    static int[] minArr;

    static class Edge implements Comparable<Edge> {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];
        minArr = new int[n + 1];
        Arrays.fill(minArr, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        minArr[1] = 0;
        pq.add(new Edge(1, 0)); 

        long cost = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentVertex = current.to;

            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;
            cost += current.cost;

            for (Edge edge : graph[currentVertex]) {
                int nextVertex = edge.to;
                int edgeCost = edge.cost;

                if (!visited[nextVertex] && minArr[nextVertex] > edgeCost) {
                    minArr[nextVertex] = edgeCost;
                    pq.add(new Edge(nextVertex, edgeCost));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int k = 1; k <= n; k++) {
            if (max < minArr[k]) {
                max = minArr[k];
            }
        }

        System.out.println(cost - max);
    }
}
