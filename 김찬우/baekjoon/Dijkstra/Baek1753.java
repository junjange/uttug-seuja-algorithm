
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int v;
    static int start;
    static int e;
    static int[] minDistance;
    static boolean[] visited;
    static Node[] adjList;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        adjList = new Node[v+1];
        minDistance = new int[v+1];
        visited = new boolean[v+1];

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to,wight,adjList[from]);
        }

        getMinDistance(start);

        for (int i=1; i<=v; i++) {
            if (minDistance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }else {
                System.out.println(minDistance[i]);
            }
        }




    }

    static void getMinDistance(int start) {

        Arrays.fill(minDistance,Integer.MAX_VALUE);
        minDistance[start] = 0;

        for (int i=1; i<=v; i++) {

            int min = Integer.MAX_VALUE;
            int stopOver = -1;

            for (int j=1; j<=v; j++) {

                if (!visited[j] && minDistance[j] < min) {
                    min = minDistance[j];
                    stopOver = j;
                }

            }
            if (stopOver == -1) {
                break;
            }

            visited[stopOver] = true;

            for (Node node = adjList[stopOver]; node != null; node = node.next) {
                if (!visited[node.vertex] && minDistance[node.vertex] > node.weight + min) {
                    minDistance[node.vertex] = node.weight + min;
                }

            }

        }

    }

    static class Node{
        int vertex;
        int weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }
}
