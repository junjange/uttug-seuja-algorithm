import java.util.*;
import java.lang.Math;

class Solution {
    
    static int n;
    static int[][] wires;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
        
    public int solution(int n, int[][] wires) {
        
        this.n = n;
        this.wires = wires;
        
        graph = new ArrayList[n+1];
        
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<wires.length; i++){
            
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        
        }
        
        for(int i = 0; i<wires.length; i++){
            
            visited = new boolean[n+1];
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            dfs(wires[i][0]);
            
            
            graph[a].add(b);
            graph[b].add(a);
            
        
        }

        return min;
    }
    
    public static void dfs(int node){
        
        int cnt =1;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(node);
        visited[node] = true;  
        
        while(!queue.isEmpty()){
            
            ArrayList<Integer> list =  graph[queue.poll()]; 
            
            for(int i=0; i<list.size(); i++){
                
                int num = list.get(i);
                
                if(!visited[num]){
                    visited[num] = true;
                    cnt++;
                    queue.offer(num);
                }
                
            }
            
            
        }
        
        min = Math.min(min,Math.abs(n-cnt-cnt));
        
        
    }
}
