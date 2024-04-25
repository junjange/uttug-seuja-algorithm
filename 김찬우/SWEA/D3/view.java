import java.io.*;
import java.util.*;
import java.lang.Math;

class Solution
{
    
    static ArrayList<Integer> max;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int test_case = 1; test_case <= 10; test_case++) {
            
             StringTokenizer st  =  new StringTokenizer(br.readLine()," ");

      	     int n = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[n];
            int cnt = 0;
            
             st =  new StringTokenizer(br.readLine()," ");
            
            for (int i=0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for (int i=2; i< n-2; i++) {
                
                max = new ArrayList<>();
                
                for (int j=-2; j<=2; j++) {
                    max.add(arr[i+j]);
                }
                
                Collections.sort(max, Collections.reverseOrder());
                
                if (max.get(0) != arr[i]) {
                    continue;
                }
                
                if (max.get(0) - max.get(1) < 1) {
                    continue;
                }
                
                
                cnt+=(max.get(0) - max.get(1));
                
     
                
            }
            
            System.out.println("#"+test_case+" "+ cnt);


        }
    }
}

















