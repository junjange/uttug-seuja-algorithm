
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

            int d = Integer.parseInt(st.nextToken());
            int result =0;
            
            if (d >= 1000000) {
                result =5;
            }
            if (d < 1000000) {
                result =4;
            }
            if (d < 100000) {
                result =3;
            }
            if (d < 10000) {
                result =2;
            }
            if (d < 1000) {
                result =1;
            }
            if (d < 100) {
                result =0;
            }
            
            System.out.println("#"+test_case+" "+result);




        }
    }
}


