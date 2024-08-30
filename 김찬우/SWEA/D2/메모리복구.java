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
            
            st = new StringTokenizer(br.readLine()," ");

            String str = st.nextToken();
            
            int[] arr = new int[str.length()];
            
            int count = 0;
            
            for (int i=0; i < str.length(); i++){
                
                if (arr[i] == (str.charAt(i)-'0')) {
                    continue;
                    
                }else {     
                    count++;
                    for (int j= i; j<str.length(); j++) {
                        arr[j] = (str.charAt(i)-'0');
                        
                    }
                    
                    
                }
                
                
            }
            
            System.out.println("#"+test_case+" "+count);
            
            
            





        }
    }
}

