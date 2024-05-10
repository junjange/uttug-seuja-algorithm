import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        long[] arr = new long[1000001];
        
        for (long i=1; i<1000001; i++) {
            
            arr[(int)i] = i*i*i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            
             st =  new StringTokenizer(br.readLine()," ");

            long n = Long.valueOf(st.nextToken());
            int result =-1;
            
            for (int i = 1; i < 1000001; i++) {
                if (arr[i] == n) {
                    result = i;
                    break;
                }
            }
            
            System.out.println("#"+test_case+" "+result);




        }
    }
}
