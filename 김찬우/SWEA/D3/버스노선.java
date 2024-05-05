
import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {

            st =  new StringTokenizer(br.readLine()," ");
           	int n = Integer.parseInt(st.nextToken());
            
            int[][] line = new int[n][2];
            
            for (int i=0; i < n; i++) {
                st =  new StringTokenizer(br.readLine()," ");
                line[i][0] =  Integer.parseInt(st.nextToken());
                line[i][1] =  Integer.parseInt(st.nextToken());
            }
            
            st =  new StringTokenizer(br.readLine()," ");
            int p = Integer.parseInt(st.nextToken());
            
            int[] result = new int[p];
            int[] busStop = new int[p];
            
              for (int i=0; i < p; i++) {
                st =  new StringTokenizer(br.readLine()," ");
                busStop[i] =  Integer.parseInt(st.nextToken());
               
            }
            
            for (int i=0; i <n ;i++) {
                
                for (int j=0; j<p; j++) {
                    
                    if (  line[i][0]<= busStop[j] && busStop[j] <= line[i][1]) {
                        result[j]++;
                    }
                    
                }
            }
            
             System.out.print("#"+test_case+" ");
            for ( int a : result) {
                System.out.print(a+" ");
            }
            System.out.println();
            




        }
    }
}

