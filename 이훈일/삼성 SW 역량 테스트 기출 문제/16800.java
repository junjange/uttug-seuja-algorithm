import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
            int max = 0;
			double N = sc.nextDouble();
            for(int i = 1; i <= Math.sqrt(N); i++) {
            	if(N % i == 0) {
                	max = Math.max(max, i);
                }
            }
            
            System.out.println("#" + test_case + " " + Math.round(N/max + max - 2));
		}
	}
}
