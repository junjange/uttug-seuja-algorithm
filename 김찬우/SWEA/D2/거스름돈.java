import java.io.*;
import java.util.*;
 
class Solution
{
    static int[] arr = {50000,10000,5000,1000,500,100,50,10}; 
    public static void main(String args[]) throws Exception
    {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st =  new StringTokenizer(br.readLine()," ");
 
        int T = Integer.parseInt(st.nextToken());
 
        for(int test_case = 1; test_case <= T; test_case++) {
             
            st =  new StringTokenizer(br.readLine()," ");
 
            int n  = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int[] result = new int[8];
             
            while (n > 9) {
                 
                for (int i=0; i<8; i++){
                     
                    int po =  n / arr[i];
                     
                      if ( po > 0) {
                         n = n - arr[i] * (po);
                         result[i] += po ;
                        break;
                    }
                     
                }
                
                 
            }
             
            System.out.println("#"+test_case);
            
            for (int a : result) {
                System.out.print(a+" ");
            }
             System.out.println();
             
 
        }
    }
}
