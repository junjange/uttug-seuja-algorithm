import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
     
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
     
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            char[] charArr = str.toCharArray();
            String result =""; 
             
            Arrays.sort(charArr);
             
            if(charArr[0] == charArr[1] && charArr[2] == charArr[3] && charArr[0] != charArr[3] ){
                System.out.println("#"+test_case+" "+"Yes");
            }else{
                System.out.println("#"+test_case+" "+"No");
            }
             
 
 
        }
    }
}
