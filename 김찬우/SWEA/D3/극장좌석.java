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
            int n = sc.nextInt();
            int[] arr =new int[n];
            int result = n; 
             
             
            for(int i=0; i<n; i++){
                arr[i]= sc.nextInt();
            }
             
            Arrays.sort(arr);
                  
            result+= (2*arr[0]);
                 
            for(int i=1; i<n; i++){
                result+= (2*arr[i])-arr[i-1]; 
                 
            }
            System.out.println("#"+test_case+" "+result);
         
        }
    }
}
