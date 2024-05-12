
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
            
             ArrayList<Integer> list =   new ArrayList<>();
            ArrayList<Integer> result =   new ArrayList<>();
            
             st =  new StringTokenizer(br.readLine()," ");

             int n = Integer.parseInt(st.nextToken());
            
             st =  new StringTokenizer(br.readLine()," ");
            for (int i=0; i < 2*n; i++ ) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            
            Collections.sort(list,Collections.reverseOrder());
            
            while (list.size() > 0) {
                
                int num = list.get(0);
                int sale = (int)(num*0.75);
                
                int index = list.lastIndexOf(sale);
                result.add(list.get(index));
                
                list.remove(index);
                list.remove(0);
                
            }
            
            Collections.sort(result);
            
              System.out.print("#"+test_case+" ");
            for (Integer a : result) {
                System.out.print(a+" ");
            }
              System.out.println();





        }
    }
}
