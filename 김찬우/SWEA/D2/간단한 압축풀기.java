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
            int[] aNum = new int[n];
            String[] alpha= new String[n];
            StringBuilder sb = new StringBuilder(); 
            int sum = 0; 
            
            for(int i =0; i<n ; i++){
                alpha[i]= sc.next();
                aNum[i] = sc.nextInt();
 
            }
             
            for(int i =0; i<n; i++){
                 
                for(int j =0; j<aNum[i]; j++){
                     
                 
                    sb.append(alpha[i]);
                     
                     
                }
            }
             
            for(int i =0; i<n; i++){
                sum+=aNum[i];
            }
             
            int circle = sum/10;
             
            System.out.println("#"+test_case);
             
            for(int j=0; j<circle; j++ ){
               
                System.out.println(sb.substring(j*10, j*10+10));
               
            }
             
            if(circle%10!=0){
                System.out.println(sb.substring(circle*10));
            }
        
         
         
 
        }
    }
}
