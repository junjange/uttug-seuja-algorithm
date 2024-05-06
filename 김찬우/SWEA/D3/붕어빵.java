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
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] arr =  new int[11112];
            String result ="";
            
             st =  new StringTokenizer(br.readLine()," ");
             for (int i=0; i<n; i++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }
     
            int bungA =0;
            int sec = 0;
            int index = 0;
            
            while (true) {
                
                if (index > n-1) {
                    result ="Possible";
                    break;
                }
                
                if (sec > 0 && sec % m == 0 ) {
                    bungA+= k;
                }
                
                if (arr[sec] == 0) {
                    sec++;
                    continue;
                }
                 
                if (bungA >= arr[sec]) {
                    index+=arr[sec];
                    bungA -= arr[sec];
                    sec++;
     
                }else {
                    result ="Impossible";
                    break;
                       
                }
                     
                
            }
            
            System.out.println("#"+test_case+" "+result);



        }
    }
}

