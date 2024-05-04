
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
            int[] arr =  new int[3]; 
            int cnt =0;
            
            for (int i=0; i<3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            

            loop1:
            for (int i=2; i >=1; i--) {
                
                if (arr[i] > arr[i-1]) {
                    continue;
                }
                
                while (arr[i] <= arr[i-1]) {
                    arr[i-1] --;
                    cnt++;
                    
                    if (arr[i-1] < 1) {
                         cnt = -1;
                        break loop1;
                    }
                    
                }
                
            }
            
            System.out.println("#"+test_case+" "+cnt);
            
            
            
            



        }
    }
}


