import java.io.*;
import java.util.*;
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
             long min = Long.MAX_VALUE;

       	    long n = Long.valueOf(st.nextToken());
            
            for (long i=1; i*i <= n; i++ ) {
                
                if (n % i == 0) {
                    
                    long x = i;
                    long y = n/i;
                    
                    long a = (x-1) + (y-1); 
                    
                    min = Math.min(a,min);
                    
                }
                
            }
            
            System.out.println("#"+test_case+" "+min);





        }
    }
}
