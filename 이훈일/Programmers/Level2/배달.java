import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int INF = 500001;
        
        int[][] graph = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i != j) {
                    graph[i][j] = INF;
                }
            }
        }
        
        for(int i = 0; i < road.length; i++) {
            int town1 = road[i][0];
            int town2 = road[i][1];
            int time = road[i][2];
            
            graph[town1][town2] = Math.min(time, graph[town1][town2]);
            graph[town2][town1] = Math.min(time, graph[town2][town1]);
        }
        
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        
        int count = 0;
        for(int j = 1; j <= N; j++) {
            if(graph[1][j] <= K) {
                count++;
            }
        }
        
        return count;
    }
}
