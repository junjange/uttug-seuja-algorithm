import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.lang.Math;
 
//345 37 2375 23 32 132 47 76 26 12
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
     
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<10;i++){
                list.add(sc.nextInt());
            }
             
            Collections.sort(list);
            list.remove(0);
            list.remove(list.size()-1);
     
            double sum = list.stream().mapToInt(Integer::intValue).sum();
            
            int result = (int)Math.round(sum/list.size());
            
            System.out.println("#" +test_case+" "+result);
 
        }
    }
}
