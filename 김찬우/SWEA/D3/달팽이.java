import java.util.*;
import java.io.*;
 
 
class Solution
{
     
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
     
    public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
     
        for(int test_case = 1; test_case <= T; test_case++)
        {
             
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
             
            int i =1;
            int startX =0;
            int startY =0;
            int d = 0;
             
            while (i <= n*n) {
                 
                arr[startX][startY] = i;
                i++;
                   
                int nx = startX+ dx[d];
                int ny = startY+ dy[d];
    
                if (nx >= n || nx < 0 || ny >= n || ny < 0 || arr[nx][ny] != 0) {
                  
                    d = (d+1) % 4;
                     startX += dx[d];
                     startY += dy[d];
                     continue;
                }
                 
               
                startX = nx;
                startY = ny;
                 
                 
                 
                 
            }
             
             System.out.println("#"+ test_case);
            for (int k=0; k<n; k++) {
                 for (int j=0; j<n; j++) {
                         System.out.print(arr[k][j]+" ");
                }
                System.out.println();
            }
 
               
         
 
        }
    }
}
