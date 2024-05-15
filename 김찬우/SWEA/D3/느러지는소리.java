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
            StringBuilder sb = new StringBuilder();
            
            st =  new StringTokenizer(br.readLine()," ");
            String str = st.nextToken();
            String[] strArr = new String[str.length()+1];
            strArr[0] ="";
            
            st =  new StringTokenizer(br.readLine()," ");
            int hipenNum = Integer.parseInt(st.nextToken());
            int[] hipen = new int[hipenNum];
            
            st =  new StringTokenizer(br.readLine()," ");
            for (int i=0; i<hipenNum; i++) {
                hipen[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(hipen);
            
            for (int i=1; i<strArr.length; i++) {
                strArr[i] = str.charAt(i-1)+"";
            }
            
            for (int i= 0; i<hipen.length; i++) {
                strArr[hipen[i]] += "-";
            }
            
            sb.append("#").append(test_case).append(" ");
            
            for (int i=0; i<strArr.length; i++) {
                sb.append(strArr[i]);
            }
            
            System.out.println(sb.toString());


        }
    }
}

