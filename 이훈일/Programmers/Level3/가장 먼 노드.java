import java.util.*;

class Solution {
    static boolean[][] graph;
    static boolean[] visited;
    static int max, N;
    static List<Integer> result;
    
    public int solution(int n, int[][] edge) {
        graph = new boolean[n+1][n+1];
        for(int i = 0; i < edge.length; i++) {
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }
        
        visited = new boolean[n+1];
        result = new ArrayList<>();
        max = 0;
        N = n;
        bfs(1);
        
        return result.size();
    }
    
    public static void bfs(int startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startNode, 0));
        visited[startNode] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int num = node.num;
            int trunk = node.trunk;
            
            for(int i = 0; i <= N; i++) {
                if(graph[num][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(i, trunk+1));
                    
                    if(trunk + 1 > max) {
                        max = trunk + 1;
                        result.clear();
                        result.add(i);
                    } else if(trunk + 1 == max) {
                        result.add(i);
                    }
                }
            }
        }
    }
    
    public static class Node {
        int num;
        int trunk;
        
        public Node(int num, int trunk) {
            this.num = num;
            this.trunk = trunk;
        }
    }
}
