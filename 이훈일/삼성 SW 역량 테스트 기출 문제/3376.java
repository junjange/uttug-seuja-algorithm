import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
			long[] dp = new long[N + 5];
            
           	dp[0] = 1;
            dp[3] = 1;
           
           	for(int i = 5; i < N + 5; i++) {
            	dp[i] = dp[i-1] + dp[i-5];
           	}
            
            System.out.println("#" + test_case + " " + dp[N + 4]);
		}
	}
}
