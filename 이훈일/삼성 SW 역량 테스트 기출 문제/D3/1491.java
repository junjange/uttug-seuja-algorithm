import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			long N = sc.nextLong();
            long A = sc.nextLong();
            long B = sc.nextLong();
            
            long min = Long.MAX_VALUE;
            for(long R = 1; R <= (long) Math.sqrt(N); R++) {
            	for(long C = R; C*R <= N; C++) {
                    min = Math.min(min, (long)(A * Math.abs(R-C)) + (long)(B * (N - R * C)));
                }
            }
            
            System.out.println("#" + test_case + " " + min);
		}
	}
}
