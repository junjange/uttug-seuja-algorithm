import java.util.Scanner;
import java.io.FileInputStream;
 
 
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
            String str1 = "bdqp";
            String str2 = "dbpq";
            StringBuilder sb = new StringBuilder();
             
            for(int i=0; i< str.length(); i++){
                 
                int index = str1.indexOf(str.charAt(i));
                sb.append(str2.charAt(index));
 
            }
               
            System.out.println("#"+test_case+" "+sb.reverse().toString());
             
             
         
         
 
        }
    }
}
