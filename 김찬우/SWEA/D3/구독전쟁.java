import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.Math;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
     
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
       
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
              sc.nextLine();
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
             int min = 0;
             
            int max = Math.min(a,b);
             
            if(a+b>=n){
                min = a+b-n;
            }
            
         
             
            System.out.println("#"+test_case+" "+max+" "+min);
             
 
 
        }
    }
}
