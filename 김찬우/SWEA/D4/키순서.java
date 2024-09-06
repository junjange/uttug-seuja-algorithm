import java.io.*;
import java.util.*;
 
public class Solution {
 
    static int[][] map;
    static boolean[] visited;
    static int n,m;
    static int result=0;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
 
        for (int test_case =1; test_case <=T; test_case ++) {
 
            st = new StringTokenizer(br.readLine());
 
            n = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            result = 0;
 
            map = new int[n+1][n+1];
 
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
 
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }
 
            for (int i = 1; i<=n; i++) {
 
                visited = new boolean[n+1];
                visited[i]=true;
 
                dfs1(i);
                dfs2(i);
 
                boolean check = true;
                for (int j=1; j<=n; j++) {
 
                    if (!visited[j]) {
                        check = false;
                        break;
                    }
                }
 
                if (check) {
                    result++;
                }
 
            }
 
            System.out.println("#"+test_case+" "+result);
 
        }
 
 
    }
 
    static void dfs1(int node) {
 
        for (int i=1; i<=n; i++) {
 
            if (map[node][i] == 1) {
 
                if (!visited[i]) {
                    visited[i] = true;
                    dfs1(i);
                }
            }
        }
    }
 
    static void dfs2(int node) {
 
        for (int i=1; i<=n; i++) {
 
            if (map[i][node] == 1) {
 
                if (!visited[i]) {
                    visited[i] = true;
                    dfs2(i);
                }
 
            }
        }
    }
}
