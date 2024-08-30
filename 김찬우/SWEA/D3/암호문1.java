import java.io.*;
import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for(int test_case = 1; test_case <= 10; test_case++) {
             
            ArrayList<Integer> list= new ArrayList<>();
             
            StringTokenizer st =  new StringTokenizer(br.readLine()," ");
 
            int n = Integer.parseInt(st.nextToken());
             
            st =  new StringTokenizer(br.readLine()," ");
             
            for (int i=0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
             
              st =  new StringTokenizer(br.readLine()," ");
             
              int m = Integer.parseInt(st.nextToken());
              int k=0;
             st =  new StringTokenizer(br.readLine()," ");
             
            while (k < m){
                 
                 String str = st.nextToken();
                 k++;
                 int index = Integer.parseInt(st.nextToken());
                 int cnt = Integer.parseInt(st.nextToken());
             
                 for (int i=0; i<cnt; i++) {
                        int num = Integer.parseInt(st.nextToken());
                        list.add(index,num);
                        index++;
                 
                 }
                 
                 
                 
            }
             
            System.out.print("#"+test_case+" ");
            for (int i=0; i<10; i++){
                System.out.print(list.get(i)+" ");
            }
             
            System.out.println();
 
 
 
        }
    }
}
