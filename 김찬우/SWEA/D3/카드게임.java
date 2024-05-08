import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            
             HashMap<Integer,Integer> map= new HashMap<>();
            
            for (int i=2; i<=11; i++) {
                
                if (i ==10) {
                    map.put(i,16);
                    continue;
                }
                map.put(i,4);
                
            }
            
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            
            for (int i=0; i<n; i++) {
                int num = Integer.parseInt(br.readLine());
                sum+=num;
                map.put(num, map.get(num)-1);
                
            }

            
            if (sum >= 21) {
                System.out.println("#"+test_case+" STOP");
                continue;
            }
            
            int chek = 21-sum;
            
            int over21 =0;
            int under21 =0;
            
           for (int key : map.keySet()) {
               int a = map.get(key);
               
               if (a == 0) {
                   continue;
               }
               
               if (chek < key) {
                   over21 += a;
               }else {
                   under21+=a;
               }
               
           }
            
            if (over21 >= under21) {
                System.out.println("#"+test_case+" STOP");
            }else {
                System.out.println("#"+test_case+" GAZUA");
            }




        }
    }
}
