import java.io.*;
import java.util.*;
import java.lang.Math;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            
            st =  new StringTokenizer(br.readLine()," ");
            String result ="yes";
            
            String str1 = st.nextToken();      
            String str2 = st.nextToken();                
            
            int str1Len = str1.length();
            int str2Len = str2.length();
            
            int a = Math.max(str1Len,str2Len);
            int b = Math.min(str1Len,str2Len);
            
            int lcd = (a*b)/ gcd(a,b) ;
            
            for (int i=0; i <lcd; i++) {
                
                char word1 =str1.charAt( i % str1Len);
                char word2 =str2.charAt( i % str2Len);
                
                if (word1 != word2) {
                    result="no";
                    break;
                }
                
            }
            
            

            System.out.println("#"+test_case+" "+result);
            
        }
    }
    
    public static int gcd(int a ,int b) {
         if(b == 0) return a;
         return gcd(b, a % b);
    }
}
