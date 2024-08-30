import java.util.*;

class Solution {
    boolean[][] graph;
    boolean[] visited;
    int limit;
    
    public int solution(int n, int[][] wires) {
        graph = new boolean[n+1][n+1];
        limit = n;
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) {
            int num1 = wires[i][0];
            int num2 = wires[i][1];
            
            graph[num1][num2] = true;
            graph[num2][num1] = true;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int num1 = wires[i][0];
            int num2 = wires[i][1];
            
            graph[num1][num2] = false;
            graph[num2][num1] = false;
            
            int net1 = bfs();
            int net2 = n - net1;
            System.out.println(net1);
            
            answer = Math.min(answer, Math.abs(net1-net2));
            
            graph[num1][num2] = true;
            graph[num2][num1] = true;
        }
        
        return answer;
    }
    
    public int bfs() {
        visited = new boolean[limit+1];
        int count = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for(int i = 1; i <= limit; i++) {
                if(graph[node][i]) {
                    if(!visited[i]) {
                        count++;
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
        
        return count;
    }
}
