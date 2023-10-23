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
        String[] score =  {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
         
         
 
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            HashMap<Integer,String> map = new HashMap<>();
             int n = sc.nextInt();
             int k = sc.nextInt();
             double[][] arr = new double[n][2];
             
            for(int i =0; i<n;i++){
                int midExm = sc.nextInt();
                int finExm = sc.nextInt();
                int task = sc.nextInt();
                 
                arr[i][0] = midExm * 0.35 + finExm*0.45+task*0.2;
                arr[i][1] = i+1;
                 
 
            }
             
            Arrays.sort(arr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[0], o1[0]);
            }
         });
          
            int scoreNum = n/10;
             
            for(int i =0; i<n;i++){
 
                int nk = (int)arr[i][1];
                map.put(nk,score[i/scoreNum]);
                 
            }
             
            System.out.println("#"+test_case +" " +map.get(k));
             
 
             
             
             
 
        }
    }
}
