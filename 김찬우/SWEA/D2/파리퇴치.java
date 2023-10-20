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
            int m = sc.nextInt();
            int[][] arr = new int[n][n]; 
            int count =0; 
            int max = 0; 
             
            for(int i =0; i < n ; i++){
                for(int j =0; j< n; j++){
                    arr[i][j] = sc.nextInt();         
                }
                 
            }
             
            for(int i =0; i<=n-m; i++ ){
                 
                for(int j =0; j<=n-m; j++){
                     
                     count =0; 
                     
                    for(int z = i; z< i+m; z++ ){
                         
                        for(int k = j; k<j+m ;k++){
                             
                            count +=arr[z][k];
                             
                        }
                    }
                     
                    if(max<count){
                        max = count;
                    }
                     
      
                     
                }
                 
              
            }
            
             
           System.out.println("#"+test_case+" "+max);
 
 
        }
    }
}
