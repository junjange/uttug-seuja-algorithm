import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int[] graph;
    static boolean[] visited;
    static int N, count;
    static int[] dx = new int[]{-1, 1};
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            graph = new int[N];
            visited = new boolean[N];
            count = 0;
            
            dfs(0);
            
            System.out.println("#" + test_case + " " + count);
		}
	}
    
    public static void dfs(int depth) {
   		if(depth == N) {
        	count++;
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                if(isPossible(i, depth)) {
                	graph[depth] = i;
                    visited[i] = true;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static boolean isPossible(int x, int y) {
    	for(int i = 0; i < y; i++) {
        	int cx = graph[i];
            int cy = i;      
            int multiple = y - cy;
            for(int k = 0; k < 2; k++) {
               	int nx = x + dx[k] * multiple;              
             	if(nx == cx) {
                    return false;
                }           
            }
        }
        return true;
    }
}
