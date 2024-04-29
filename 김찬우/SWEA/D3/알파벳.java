import java.io.*;
import java.util.*;

class Solution
{
    static char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            
            Set<Character> set = new TreeSet<>();
            
            st =  new StringTokenizer(br.readLine()," ");

            int n = Integer.parseInt(st.nextToken());
            
            for (int i=0; i<n; i++){
                
                st =  new StringTokenizer(br.readLine()," ");
                String str = st.nextToken();
                set.add(str.charAt(0));
                
            }
            
            Iterator<Character> it = set.iterator(); 
            
            int cnt = 0;
            
            ArrayList<Character> list = new ArrayList<>();
            
            
            while (it.hasNext()){
                list.add(it.next());
            }
            
           
            for (int i=0; i < list.size(); i++) {
                
                if (arr[i] != list.get(i)) {
                    break;
                }
                cnt++;
                
                
            }
            
            
              System.out.println("#"+test_case+" "+cnt);
            

        }
    }
}



