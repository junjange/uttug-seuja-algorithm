import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
 
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
           int n = sc.nextInt();
           int[][] arr =new int[100][100];
            int sum = 0;
            int sum1 = 0;
            List<Integer> list = new ArrayList<>();
             
             
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
             
            for(int i =0; i<100; i++){
                sum = 0;
                sum1= 0;
                 
                for(int j=0; j<100; j++){     
                    sum+=arr[i][j];   
                    sum1+=arr[j][i];
                }
                 
                list.add(sum);
                list.add(sum1);
          
            }
   
            sum = 0;
            sum1 = 0;
            for(int k =0; k<100; k++){
               sum+=arr[k][k];
               sum1+=arr[k][99-k];  
            }
             
            list.add(sum);
            list.add(sum1);
 
            int answer = Collections.max(list);
             
            System.out.println("#"+test_case+" "+answer);
             
             
         
 
 
        }
    }
}
