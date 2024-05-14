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
            
            int count = 1;
            
             if(n==1){
                System.out.println("#"+ test_case+" "+count);
                continue;
            }
            
            
           for (int i=1; i<=n/2+1; i++) {
               
               int sum = 0;
               for (int j = i; j<=n/2+1; j++) {
                   
                   sum+=j;
                   if (sum == n) {
                       count++;
                       break;
                   }
                   
                    if (sum > n) {
                       break;
                   }
                   
               }
               
           }
            
            System.out.println("#"+test_case+" "+count);




        }
    }
}






