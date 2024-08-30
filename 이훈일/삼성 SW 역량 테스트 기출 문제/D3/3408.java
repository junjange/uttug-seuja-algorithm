import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			long N = sc.nextLong();
            long S1 = (N * (N + 1)) / 2;
            long S2 = S1 * 2 - N;
            long S3 = S1 * 2;
            
            System.out.printf("#%d %d %d %d%n", test_case, S1, S2, S3); 
		}
	}
}
