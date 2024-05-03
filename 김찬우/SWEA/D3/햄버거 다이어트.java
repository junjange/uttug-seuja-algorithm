
import java.io.*;
import java.util.*;
import java.lang.Math;

class Solution
{
    static int[][] arr;
    static boolean[] visited;
    static int n, total,max ;
    
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            
            st =  new StringTokenizer(br.readLine()," ");

        	n = Integer.parseInt(st.nextToken());
            total = Integer.parseInt(st.nextToken());
            visited = new boolean[n];
            arr = new int[n][2];
            max = Integer.MIN_VALUE;
            
            for (int i=0; i<n; i++) {
                st =  new StringTokenizer(br.readLine()," ");
                arr[i][0] =  Integer.parseInt(st.nextToken());
                arr[i][1] =  Integer.parseInt(st.nextToken());
            }
            
            bfs(0,0,0);
            
            System.out.println("#"+test_case+" "+max);




        }
    }
    public static void bfs(int depth, int satisfy, int calorie) {
        
        if (calorie <= total) {
            
            // 만족도 최대값 갱신
            max  = Math.max(max,satisfy);
        }
        
        if (calorie > total) {
            //System.out.println("calorie "+ calorie+ " satisify "+satisfy+" total "+total);
            return;
        }
        
        if (depth == n) {
            return;
        }
        
        bfs(depth+1,satisfy + arr[depth][0], calorie + arr[depth][1]);
        bfs(depth+1,satisfy,calorie);
        
        
        
    }
}

