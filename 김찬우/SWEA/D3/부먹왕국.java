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
            int d = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[n];
            
             st =  new StringTokenizer(br.readLine()," ");
            for (int i=0; i<n; i++) {
                arr[i] =  Integer.parseInt(st.nextToken());
            }
            
            int index = -1;
            int cnt =0;
            
            loop:
            while (index < n - d) {
                
                for (int i = d; i > 0; i--) {
                    
                    if (arr[index+i] == 1) {
                        index += i;
                        continue loop;
                        
                    }
                }
                
                index+=d;
                cnt++;
                
                
            }
            
            System.out.println("#"+test_case+" "+cnt);
            




        }
    }
}
