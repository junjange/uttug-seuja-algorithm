
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringBuilder sb = new StringBuilder();
		
			int n = sc.nextInt();
            
            for (int i=0; i < n; i++) {
                sb.append(sc.next());
            }
            
            int k = 0;
            while (true) {
                if (!sb.toString().contains(String.valueOf(k))) {
                    break;
                }
                
                 k++;
                
                
            }
            System.out.println("#"+test_case+" "+k);

		}
	}
}
