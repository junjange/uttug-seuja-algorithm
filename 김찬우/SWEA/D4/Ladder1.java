import java.util.*;
import java.io.*;


class Solution
{
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1};
    static int[] dy = {-1,1,0};
    static int result;
    
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
		for(int test_case = 1; test_case <= 10; test_case++)
		{
             StringTokenizer st =  new StringTokenizer(br.readLine()," ");
        
             int T = Integer.parseInt(st.nextToken());
            
            arr = new int[100][100];
            
            for (int i = 0; i < 100; i++) {
                
                st =  new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < 100; j++) {
                    
                     arr[i][j] = Integer.parseInt(st.nextToken());
                    
                    if (arr[i][j] == 2) {
                        result = j;
                    }
                    
               
                }
            }
            
                    
            visited = new boolean[100][100];

            int startX = 99;
            int startY = result;

            while (true) {
                
                for (int i=0; i < 3; i++) {
                    
                    int nx = dx[i] + startX;
                    int ny = dy[i] + startY;
                    
                    if (nx < 0 || nx > 99 || ny < 0 || ny > 99 ) {
                        continue;
                    }
                    
                    if (arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        startX = nx;
                        startY = ny;
                        break;
                    }
                    
                }
                
                if ( startX == 0) {
             
                    break;
                }
                
                
            }
            
            System.out.println("#"+test_case+" "+startY);

                
		

		}
	}
    
  
}
