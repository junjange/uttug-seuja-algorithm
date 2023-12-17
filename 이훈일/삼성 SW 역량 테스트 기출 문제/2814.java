import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static int N;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int max;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            int M = sc.nextInt();
            
            graph = new List [N + 1];
           	for(int i = 0; i <= N; i++) {
            	graph[i] = new ArrayList<Integer>(); 
            }
            
            for(int i = 0; i < M; i++) {
            	int point1 = sc.nextInt();
                int point2 = sc.nextInt();
                
                graph[point1].add(point2);
                graph[point2].add(point1);
            }
            
            visited = new boolean[N + 1];
            max = Integer.MIN_VALUE;
            for(int i = 1; i <= N; i++) {
            	visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }
            
            System.out.println("#" + test_case + " " + max);
		}
	}
    
    public static void dfs(int start, int cnt) {
    	max = Math.max(max, cnt);
        
        List<Integer> points = graph[start];
        for(int i = 0; i < points.size(); i++) {
        	if(!visited[points.get(i)]) {
            	visited[points.get(i)] = true;
            	dfs(points.get(i), cnt + 1);
                visited[points.get(i)] = false;
            }
        }
    }
}
