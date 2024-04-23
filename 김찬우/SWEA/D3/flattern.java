import java.io.*;
import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        
 
        for(int test_case = 1; test_case <= 10; test_case++) {
             
            StringTokenizer st =  new StringTokenizer(br.readLine()," ");
 
            int dumpCnt = Integer.parseInt(st.nextToken());
             
            ArrayList<Integer> list = new ArrayList<>();
             
             st =  new StringTokenizer(br.readLine()," ");
             
            for (int i=0; i<100; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
             
            for (int i=0; i<dumpCnt; i++) {
                 
                int max = Collections.max(list);
                int min = Collections.min(list);
                 
                int maxIndex = list.indexOf(max);
                int minIndex = list.indexOf(min);
                 
                list.remove(maxIndex);
                list.add(maxIndex, max-1);
                 
                list.remove(minIndex);
                list.add(minIndex, min+1);
                 
                 
            }
             
            int result = Collections.max(list) - Collections.min(list);
            System.out.println("#"+test_case+" "+ result);
 
 
 
 
        }
    }
}
