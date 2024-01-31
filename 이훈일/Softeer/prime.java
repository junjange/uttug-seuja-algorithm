import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static HashMap<Integer, Integer>[] graph;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new HashMap[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new HashMap<Integer, Integer>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].put(B, C);
            graph[B].put(A, C);
        }

        dfs(1, Integer.MIN_VALUE);

        min++;
        while(!isPrime(min)) {
            min++;
        }
        
        System.out.println(min);
    }

    public static void dfs(int node, int level) {
        if(node == N) {
            min = Math.min(min, level);
            return;
        }

        HashMap<Integer, Integer> gyms = graph[node];
        for(int gym : gyms.keySet()) {
            if(!visited[gym]) {
                visited[gym] = true;
                dfs(gym, Math.max(level, gyms.get(gym)));
                visited[gym] = false;
            }
        }
    }

    public static boolean isPrime(int num) {
        if(num < 2) {
            return true;
        }

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
