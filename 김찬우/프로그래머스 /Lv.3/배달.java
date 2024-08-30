import java.util.*;

class Solution {
    
    static List<ArrayList<Node>> list;
    static int[] visited;
    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 1;

        list = new ArrayList<>();
        visited = new int[N+1];
        
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0; i < road.length; i++) {
            list.get(road[i][0]).add(new Node(road[i][0],road[i][1],road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1],road[i][0],road[i][2]));
            
        }
        
        for (int i=2; i<=N; i++){
            visited[i] = Integer.MAX_VALUE;
        }
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.addAll(list.get(1));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (visited[node.x] <= visited[node.y] + node.z) {
                continue;
            }
            
            visited[node.x] = visited[node.y] + node.z;
            queue.addAll(list.get(node.x));
        }
        
        
        for (int i=2; i<=N; i++) {
            if (visited[i] <= K) {
                answer++;
            }
        }
        

        return answer;
    }
    
    static class Node {
        
        int y;
        int x;
        int z;
        
        public Node(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
            
            
        }
        
    }
    
    
}
