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
            StringBuilder sb = new StringBuilder();
            
            Stack<Integer> stack = new Stack<>();
			int n = sc.nextInt();
            String str = sc.next();

            int i = 0;
            while (i < str.length()) {
                
                char word = str.charAt(i);
                
                if (word == '+') {
                    i++;
                 	continue;
                }
                
                if (word == '*') {
                 	int num = stack.pop();
                    stack.push(num* (str.charAt(i+1) -'0'));
                    i +=2;
                    continue;
                }
                
                i++;
                stack.push(word-'0');

                
            }
            
            int len = stack.size();
            long sum =0;
            
            for (int j=0; j<len; j++) {
                sum+= stack.pop();
            }
            
            System.out.println("#"+test_case+" "+sum);
            

		}
	}
}
